package net.imagini.zkcli;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.internal.Lists;

import java.util.List;

public class CliParameters {
    @Parameter
    List<String> positionalParameters = Lists.newArrayList();

    @Parameter(names = { "--cluster", "-c" },
            description = "Aliased Cluster Name")
    String cluster;

    @Parameter(names = { "--zkConnect", "-z" },
            description = "Zookeeper connection string for non aliased cluster")
    String zkConnect;

    @Parameter(names = { "--ls", "-l" },
            description = "Print child nodes")
    boolean listChildren;

    @Parameter(names = { "--printPaths", "-p" },
            description = "When printing node names include full paths")
    boolean printPaths;

    @Parameter(names = { "--get", "-g" },
            description = "Print data of path* requires a path and cluster")
    boolean getData;

    @Parameter(names = { "--getMeta", "-m" },
            description = "Whether to print metadata* requires a path and cluster")
    boolean getMeta;

    @Parameter(names = { "--metaField", "-f" },
            description = "A specific field of the stat object to get. Expects getter name")
    String specificMetaFieldGetter;

    @Parameter(names = { "--listMetaFieldAccessors", "-a" },
            description = "List accessors available for meta field access")
    boolean listMetaAccessors;

    @Parameter(names = { "--help", "-h", "-?" },
            description = "Display this help",
            help = true)
    boolean help;

    private final JCommander argProcessor;

    public CliParameters(String[] args) {
        argProcessor = new JCommander(this, args);
    }

    public boolean includesAction() {
        return listMetaAccessors || listChildren || getMeta || getData || help;
    }

    void printUsage() {
        argProcessor.usage();
    }
}
