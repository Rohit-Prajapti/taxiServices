package com.rudrabannataxiservices.rudrabannataxiservices.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(
            ResourceHandlerRegistry registry
    ) {

        // Current deployed app path
        String appPath =
                System.getProperty("catalina.base")
                        + "/webapps/rudrabannataxiservices/";

        // Upload folder path
        String uploadPath = appPath + "uploads/";

        System.out.println("📁 Upload Path: " + uploadPath);

        // Main Uploads
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:" + uploadPath)
                .setCachePeriod(3600);

        // Cars Images
        registry.addResourceHandler("/cars/**")
                .addResourceLocations(
                        "file:" + uploadPath + "cars/"
                )
                .setCachePeriod(3600);

        // Gallery Images
        registry.addResourceHandler("/gallery/**")
                .addResourceLocations(
                        "file:" + uploadPath + "gallery/"
                )
                .setCachePeriod(3600);

        // Banner Images
        registry.addResourceHandler("/banners/**")
                .addResourceLocations(
                        "file:" + uploadPath + "banners/"
                )
                .setCachePeriod(3600);
    }
}
//package com.rudrabannataxiservices.rudrabannataxiservices.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    @Value("${file.upload.directory:uploads}")
//    private String uploadDirectory;
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//
//        // Get absolute path for uploads directory
//        Path uploadPath = Paths.get(System.getProperty("user.dir"), uploadDirectory);
//        String uploadAbsolutePath = uploadPath.toFile().getAbsolutePath() + "/";
//
//        System.out.println("📁 Serving images from: " + uploadAbsolutePath);
//
//        // Map /uploads/** to actual file system directory (for /uploads/cars/, /uploads/gallery/)
//        registry.addResourceHandler("/uploads/**")
//                .addResourceLocations("file:" + uploadAbsolutePath)
//                .setCachePeriod(3600);
//
//        // ADD THIS: Map /gallery/** to uploads/gallery/ for backward compatibility
//        Path galleryPath = Paths.get(System.getProperty("user.dir"), uploadDirectory, "gallery");
//        String galleryAbsolutePath = galleryPath.toFile().getAbsolutePath() + "/";
//
//        registry.addResourceHandler("/gallery/**")
//                .addResourceLocations("file:" + galleryAbsolutePath)
//                .setCachePeriod(3600);
//
//        System.out.println("📁 Gallery images from: " + galleryAbsolutePath);
//
//        // ADD THIS: Map /cars/** to uploads/cars/ for backward compatibility
//        Path carsPath = Paths.get(System.getProperty("user.dir"), uploadDirectory, "cars");
//        String carsAbsolutePath = carsPath.toFile().getAbsolutePath() + "/";
//
//        registry.addResourceHandler("/cars/**")
//                .addResourceLocations("file:" + carsAbsolutePath)
//                .setCachePeriod(3600);
//
//        System.out.println("📁 Car images from: " + carsAbsolutePath);
//
//        // Serve static resources
//        registry.addResourceHandler("/static/**")
//                .addResourceLocations("classpath:/static/");
//
//        // Serve images directly from root (optional)
//        registry.addResourceHandler("/images/**")
//                .addResourceLocations("file:" + uploadAbsolutePath)
//                .setCachePeriod(3600);
//    }
//}
//
////package com.rudrabannataxiservices.rudrabannataxiservices.config;
////
////import org.springframework.beans.factory.annotation.Value;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
////import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
////
////import java.nio.file.Path;
////import java.nio.file.Paths;
////
////@Configuration
////public class WebConfig implements WebMvcConfigurer {
////
////    @Value("${file.upload.directory:uploads}")
////    private String uploadDirectory;
////
////    @Override
////    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////
////        // Get absolute path for uploads
////        Path uploadPath = Paths.get(System.getProperty("user.dir"), uploadDirectory);
////        String uploadAbsolutePath = uploadPath.toFile().getAbsolutePath() + "/";
////
////        System.out.println("📁 Serving images from: " + uploadAbsolutePath);
////
////        // Map /uploads/** to actual file system directory
////        registry.addResourceHandler("/uploads/**")
////                .addResourceLocations("file:" + uploadAbsolutePath)
////                .setCachePeriod(3600); // Cache for 1 hour
////
////        // Also serve static resources
////        registry.addResourceHandler("/static/**")
////                .addResourceLocations("classpath:/static/");
////    }
////}
