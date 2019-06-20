package top.cfish.openapi.sdk.test.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class YApiResponse
{
    private Message message;
    private String runtime;
    private CaseInfo caseInfo;
}
