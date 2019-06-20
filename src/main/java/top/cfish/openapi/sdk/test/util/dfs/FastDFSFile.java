package top.cfish.openapi.sdk.test.util.dfs;

import com.google.common.io.Files;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;


/**
 * @author: isisiwish
 * @date: 2019/6/16
 * @time: 18:12
 */
@Slf4j
@Getter
@Setter
public class FastDFSFile
{
    private String name;
    
    private byte[] content;
    
    private String ext;
    
    private String md5;
    
    private String author;
    
    public FastDFSFile(String name, byte[] content, String ext, String height, String width, String author)
    {
        super();
        this.name = name;
        this.content = content;
        this.ext = ext;
        this.author = author;
    }
    
    public FastDFSFile(String name, byte[] content, String ext)
    {
        super();
        this.name = name;
        this.content = content;
        this.ext = ext;
    }
    
    public static String saveFile(String file) throws IOException
    {
        String[] fileAbsolutePath = {};
        String ext = file.substring(file.lastIndexOf(".") + 1);
        File htmlFile = new File(file);
        byte[] file_buff = Files.toByteArray(htmlFile);
        FastDFSFile f = new FastDFSFile(file, file_buff, ext);
        try
        {
            fileAbsolutePath = FastDFSClient.upload(f);
        }
        catch (Exception e)
        {
            log.error("upload file Exception", e);
        }
        if (fileAbsolutePath == null)
        {
            log.error("upload file failed, please upload again");
        }
        String path = FastDFSClient.getTrackerUrl() + fileAbsolutePath[0] + "/" + fileAbsolutePath[1];
        return path;
    }
}
