package com.gd.android.demolib;

import android.app.Activity;
import android.util.ArraySet;

import androidx.annotation.NonNull;

import org.godotengine.godot.Godot;
import org.godotengine.godot.plugin.GodotPlugin;
import org.godotengine.godot.plugin.SignalInfo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InstantiateSingleton extends  GodotPlugin {

    private Activity m_Activity;

    public InstantiateSingleton(Godot godot) {
        super(godot);
        m_Activity = godot;
    }

    @NonNull
    @Override
    public String getPluginName() {

        return "DemoPlugin";
    }

    @NonNull
    @Override
    public List<String> getPluginMethods() {

        return Arrays.asList("SayHello",
                "TriggerSignal");
    }

    @NonNull
    @Override
    public Set<SignalInfo> getPluginSignals() {
        Set<SignalInfo> signals = new HashSet<>();

        signals.add(new SignalInfo("OnSignalTriggered", String.class));

        return signals;

    }

    public String SayHello(String user) {

        return ("Hello, " + user);
    }

    public  void TriggerSignal()
    {
        emitSignal("OnSignalTriggered","SignalFromPlugin");
    }
}
