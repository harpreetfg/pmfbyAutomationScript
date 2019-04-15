package com.pmfby.utility;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.core.Logger;

import static org.apache.logging.log4j.LogManager.getLogger;

public class Loggers {

    public static Logger logger = (Logger) getLogger(Loggers.class.getName());

    public static void main(String[] args){
        PropertyConfigurator.configure("log4j.properties");
    }
}
