package de.hpi.data_change.imdb.change_extraction;

import java.io.File;
import java.io.IOException;

public class DiffApplyer {

    public boolean applyDiffBackwards(File original, File diffFile, File target) throws IOException, InterruptedException {
        String cmd = "patch";
        String arg1 = "-R";
        String arg2 = original.getAbsolutePath();
        String arg3 = diffFile.getAbsolutePath();
        String arg4 = "-o";
        String arg5 = target.getAbsolutePath();
        System.out.println("executing " + cmd + " " + arg1 + " " + arg2 + " " + arg3 + " " + arg4 + " " + arg5);
        ProcessBuilder pb = new ProcessBuilder(cmd,arg1,arg2,arg3,arg4,arg5)
                .redirectErrorStream(true);
        pb.inheritIO();
        execute(pb);
        if(new File(target.getAbsolutePath() + ".rej").exists()){
            System.err.println("Houston we have a problem...");
            return false;
        } else{
            return true;
        }
    }

    private void execute(ProcessBuilder pb) throws IOException, InterruptedException {
        Process p = pb.start();
        p.waitFor();
    }

}
