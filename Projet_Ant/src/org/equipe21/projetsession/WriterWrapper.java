package org.equipe21.projetsession;

import java.io.IOException;
import java.io.Writer;

public class WriterWrapper {
    
    private final Writer writer;
    
    public WriterWrapper(Writer writer){
        this.writer = writer;
    }
    
    
    public void write(String data) throws IOException {
        writer.write(data);
    }
    
    
    public void flush() throws IOException {
        writer.flush();
    }
    
    
    public void close () throws IOException {
        writer.close();
    }
}
