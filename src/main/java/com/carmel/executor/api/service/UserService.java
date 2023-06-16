package com.carmel.executor.api.service;

import com.carmel.executor.api.entity.User;
import com.carmel.executor.api.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import static org.aspectj.bridge.MessageUtil.fail;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Async
    public CompletableFuture<List<User>> saveUsers(MultipartFile file) throws Exception {
        long start = System.currentTimeMillis();
        List<User> users = parseCsv(file);
        logger.info("saving list of user of size {}", users.size(), "" + Thread.currentThread().getName());
        users = repository.saveAll(users);
        long end = System.currentTimeMillis();
        logger.info("Total time {}", (end-start));
        return CompletableFuture.completedFuture(users);
    }

    public void saveUsersAsync(MultipartFile file){
        CompletableFuture.runAsync(() -> {
            try {
                List<User> users = parseCsv(file);
                repository.saveAll(users);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });
    }

    @Async
    public CompletableFuture<List<User>> findAllUsers(){
        logger.info("get list of users by " + Thread.currentThread().getName());
        List<User> users = repository.findAll();
        return CompletableFuture.completedFuture(users);
    }

    private List<User> parseCsv(final MultipartFile file) throws Exception {
         final List<User> users = new ArrayList<>();
         try {
             try(final BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))){
                 String line;
                 while ((line= br.readLine()) != null){
                     final String[] data = line.split(",");
                     final User user=new User();
                     user.setName(data[0]);
                     user.setEmail(data[1]);
                     user.setCompany(data[2]);
                     users.add(user);
                 }
                 return users;
             }
         }catch (final IOException e){
             logger.error("Failed to parse CSV file {}", e);
             throw new Exception("Failed to parse CSV file {}", e);
         }
    }

    // use with lambdas like: eventually(() -> yourFunction());
    protected void eventually(Runnable code) throws InterruptedException {
        Instant started = Instant.now();
        Function<Duration, Boolean> hasPassed =
                x -> Duration.between(started, Instant.now()).compareTo(x) > 0;
        boolean isSuccessful = false;
        while (!isSuccessful) {
            try {
                code.run();
                isSuccessful = true;
            } catch (Throwable ignore) {
                if (hasPassed.apply(Duration.ofSeconds(30))) {
                    fail("Code did not succeed in time.");
                } else {
                    Thread.sleep(200);
                    isSuccessful = false;
                }
            }
        }
    }
}
