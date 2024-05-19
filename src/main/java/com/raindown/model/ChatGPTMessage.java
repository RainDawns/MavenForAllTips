package com.raindown.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChatGPTMessage {

    private String role;

    private String content;
}
