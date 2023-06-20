package com.carmel.springSnippents.IOwithWatcher;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

public class DirMonitor {
    private static WatchService watchService = null;

    private static void init(){
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        Path path = Paths.get("/Users/testuser/Documents/GitHub/spring-snippents/");
        try {
            watchService = FileSystems.getDefault().newWatchService();
            path.register(watchService, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void doRounds(){
        WatchKey key = null;
        while (true){
            try{
                key = watchService.take();
                for(WatchEvent<?> event : key.pollEvents()){
                    WatchEvent.Kind<?> kind = event.kind();
                    System.out.println("Event on " + event.context().toString() + " " + kind);
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException: " + e.getMessage());
            }
            assert key != null;
            boolean reset = key.reset();
            if(!reset){
                break;
            }
        }
    }

    public static void run(){
        DirMonitor.init();
        DirMonitor.doRounds();
    }
}
