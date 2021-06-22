package com.ecommerce.tests;

import java.util.Map;
import java.util.Properties;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.condition.JRE;
 
@DisplayName("JUnit 5 Conditional Tests Example")
@RunWith(JUnitPlatform.class)
public class ConditionalTests {

        @Test
        @EnabledOnOs({OS.WINDOWS})
        public void runOnWindows() {
                System.out.println("This runs on Windows");
        }

        @Test
        @EnabledOnOs({OS.LINUX})
        public void runOnLinux() {
                System.out.println("This runs on Linux");
        }
        
        @Test
        @EnabledOnOs({OS.LINUX, OS.WINDOWS})
        void onLinuxOrWindows() {
            System.out.println("Run this on Linux or Windows!");
        }

        @Test
        @DisabledOnOs(OS.LINUX)
        void notOnWindows() {
            System.out.println("Do not run this on Windows!");
        }
        
        
        //-------------------- Java Runtime Environment ---------------------//
        
        @Test
        @EnabledOnJre(JRE.JAVA_9)
        void onJava9() {
            System.out.println("Run this on Java 9");
        }

        @Test
        @EnabledOnJre({JRE.JAVA_12, JRE.JAVA_13})
        void onJava12OrJava13() {
            System.out.println("Run this on Java 12 or Java 13");
        }

        @Test
        @DisabledOnJre(JRE.JAVA_9)
        void notOnJava9() {
            System.out.println("Do not run this on Java 9");
        }
        
        
        
        //-------------------  System Property -----------------------------//
        
        @Test
        @EnabledIfSystemProperty(named = "java.vm.name", matches = ".*OpenJDK.*")
        void onOpenJDK() {
            System.out.println("Run this on OpenJDK!");
        }

        @Test
        @DisabledIfSystemProperty(named = "user.country", matches = "MY")
        void notOnCountryMalaysia() {
            System.out.println("Do not run this on country code MY");
        }

        @Test
        void printSystemProperties() {
            Properties properties = System.getProperties();
            properties.forEach((k, v) -> System.out.println(k + ":" + v));
        }
        
        // ------------------------- Environment Variable -------------------------//
        
        @Test
        @EnabledIfEnvironmentVariable(named = "PROCESSOR_IDENTIFIER", matches = ".*Intel64 Family 6.*")
        void onIntel64() {
            System.out.println("Run this on Intel6 Family 6 only.");
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "NUMBER_OF_PROCESSORS", matches = "8")
        void onProcessor8() {
            System.out.println("Run this if it has 8 processors.");
        }

        @Test
        @DisabledIfEnvironmentVariable(named = "CURRENT_ENV", matches = ".*development.*")
        void notOnDeveloperPC() {
            System.out.println("Do not run this if env variables 'CURRENT_ENV' matches .*development.* ");
        }

        @Test
        void printEnvironmentProperties() {
            Map<String, String> env = System.getenv();
            env.forEach((k, v) -> System.out.println(k + ":" + v));
        }
        
        
        
        //------------------------------ SCRIPT BASED-----------------------------------------//
        
        @Test
        @DisabledIf("Math.random() < 0.314159")
        void mightNotBeExecuted() {
                System.out.println("This may or not execute ");
        }
}

