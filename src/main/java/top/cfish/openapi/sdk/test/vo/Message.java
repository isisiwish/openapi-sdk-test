package top.cfish.openapi.sdk.test.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message
{
    private String msg;
    private int len;
    private int succesSnum;
    private int failedNum;
}
