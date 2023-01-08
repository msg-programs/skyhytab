package com.msgprograms.skyhytab;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

import me.shedaniel.autoconfig.AutoConfig;

public class ModMenuIntegr implements ModMenuApi{
    
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> {return AutoConfig.getConfigScreen(Cnf.class, parent).get();};
    }

}
