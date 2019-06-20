package top.cfish.openapi.sdk.test.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class CaseInfo<T>
{
    private int id;
    private String name;
    private String path;
    private int code;
    private int status;
    private String url;
    private String resBody;
    private Map<String, T> params;
}
