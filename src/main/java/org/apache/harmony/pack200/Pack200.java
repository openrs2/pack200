package org.apache.harmony.pack200;

import org.apache.harmony.unpack200.Pack200UnpackerAdapter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.SortedMap;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;

public final class Pack200 {
    public static Packer newPacker() {
        return new Pack200PackerAdapter();
    }

    public static Unpacker newUnpacker() {
        return new Pack200UnpackerAdapter();
    }

    public interface Packer {
        String SEGMENT_LIMIT = "pack.segment.limit";
        String KEEP_FILE_ORDER = "pack.keep.file.order";
        String EFFORT = "pack.effort";
        String DEFLATE_HINT = "pack.deflate.hint";
        String MODIFICATION_TIME = "pack.modification.time";
        String PASS_FILE_PFX = "pack.pass.file.";
        String UNKNOWN_ATTRIBUTE = "pack.unknown.attribute";
        String CLASS_ATTRIBUTE_PFX = "pack.class.attribute.";
        String FIELD_ATTRIBUTE_PFX = "pack.field.attribute.";
        String METHOD_ATTRIBUTE_PFX = "pack.method.attribute.";
        String CODE_ATTRIBUTE_PFX = "pack.code.attribute.";
        String PROGRESS = "pack.progress";

        String KEEP = "keep";
        String PASS = "pass";
        String STRIP = "strip";
        String ERROR = "error";
        String TRUE = "true";
        String FALSE = "false";
        String LATEST = "latest";

        SortedMap<String,String> properties();
        void pack(JarFile in, OutputStream out) throws IOException;
        void pack(JarInputStream in, OutputStream out) throws IOException ;
    }

    public interface Unpacker {
        String DEFLATE_HINT = "unpack.deflate.hint";
        String PROGRESS = "unpack.progress";

        String KEEP = "keep";
        String TRUE = "true";
        String FALSE = "false";

        SortedMap<String,String> properties();
        void unpack(InputStream in, JarOutputStream out) throws IOException;
        void unpack(File in, JarOutputStream out) throws IOException;
    }

    private Pack200() {
        /* empty */
    }
}
