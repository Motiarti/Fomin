package ru.Sberbank.LogHandler;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TargetFiles {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("LogPath")
    private String logPath;
    @JsonIgnore
    private String id;

    public TargetFiles() {
    }

    public TargetFiles(String name, String logPath, String id) {
        this.setName(name);
        this.setLogPath(logPath);
        this.setId(id);
    }

    ObjectMapper mapper = new ObjectMapper();

    public List<TargetFiles> logList(String jsonName) {
        ArrayList<TargetFiles> files = new ArrayList<>();
        try {
            return mapper.readValue(new File(jsonName), new TypeReference<ArrayList<TargetFiles>>() {
            });
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return files;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogPath() {
        return logPath;
    }

    public void setLogPath(String logPath) {
        this.logPath = logPath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
