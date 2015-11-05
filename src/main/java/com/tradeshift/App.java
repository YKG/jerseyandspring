package com.tradeshift;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created by ykg on 05/11/15.
 */
public class App extends ResourceConfig{
    public App(){
      packages("com.tradeshift");
    }
}
