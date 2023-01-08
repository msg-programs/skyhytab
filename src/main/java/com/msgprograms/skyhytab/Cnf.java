package com.msgprograms.skyhytab;

import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.ConfigData;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;


@Config(name = "skyhytab")
@Environment(EnvType.CLIENT)
public class Cnf implements ConfigData {

    public boolean enabled = true;

}
