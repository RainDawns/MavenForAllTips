//package com.raindown.chatGPT;
//
//import cn.hutool.core.collection.CollectionUtil;
//import cn.hutool.http.HttpRequest;
//import cn.hutool.json.JSONUtil;
//import com.google.common.base.Strings;
//import com.raindown.model.ChatGptParam;
//import com.raindown.model.ChatGptResult;
//import lombok.extern.slf4j.Slf4j;
//import java.util.*;
//
///**
// * chatGpt 工具类
// */
////@Slf4j
//public class ChatGptUtil {
//    private static final String URL = "https://api.openai.com/v1/completions";
//    private static final String NEW_URL = "https://api.openai.com/v1/chat/completions";
//    private static final Integer MAX_TOKENS = 2048;
//    private static final String MODEL = "text-davinci-003";
//    private static final String API_KEY = "";
//
//    /**
//     * 调用chatGPT接口
//     * @describe 支持上下文问答
//     *  请求示例：
//     *      问：hello
//     *      答：hello!
//     *      问：Who are you?
//     *  请求格式：(You:hello\n)hello!(You:Who are you?)
//     * @param historyAnswer 回答历史
//     * @param newQuestion 新问题
//     * @return
//     */
//    public static String chatGPTRequest(List<ChatGptParam> historyAnswer, String newQuestion) {
////        Assert.hasLength(newQuestion, "Question cannot be empty!");
//
//        StringBuilder sb = new StringBuilder();
//        //拼接历史回答
//        if (!CollectionUtil.isEmpty(historyAnswer)) {
//            for (ChatGptParam item : historyAnswer) {
//
//                if (!Strings.isNullOrEmpty(item.getQuestion())) {
//                    sb.append("(You:").append(item.getQuestion()).append("\n)");
//                }
//                if (!Strings.isNullOrEmpty(item.getAnswer())) {
//                    sb.append(item.getQuestion());
//                }
//            }
//        }
//        //拼接新问题
//        sb.append("(You:").append(newQuestion).append(")");
//
//        //组装参数
//        HashMap<String, Object> params = new HashMap<>();
//        params.put("prompt", sb.toString());
//        params.put("max_tokens", MAX_TOKENS);
//        params.put("model", MODEL);
//        //请求chatGPT接口
//        String result = HttpRequest.post(URL)
//                .auth("Bearer " + API_KEY)
//                .contentType("application/json")
//                .body(JSONUtil.toJsonStr(params))
//                .execute()
//                .body();
//        ChatGptResult chatGptResult = JSONUtil.toBean(result, ChatGptResult.class);
//        return chatGptResult.getChoices().get(0).getText();
//    }
//
//    /**
//     * 基于ChatGPT最新模型调用
//     * @param historyAnswer
//     * @param newQuestion
//     * @return
//     */
//    public static String chatGPTRequestNew(List<ChatGptParam> historyAnswer, String newQuestion) {
////        Assert.hasLength(newQuestion, "Question cannot be empty!");
//
//        //拼接历史回答
//        List<Map<String, Object>> list = new ArrayList<>();
//        if (!CollectionUtil.isEmpty(historyAnswer)) {
//            for (ChatGptParam item : historyAnswer) {
//                Map<String, Object> message = new HashMap<>();
//                message.put("role", "user");
//                message.put("content", item.getQuestion());
//                list.add(message);
//
//                message = new HashMap<>();
//                message.put("role", "assistant");
//                message.put("content", item.getAnswer());
//                list.add(message);
//            }
//        }
//        //拼接新问题
//        Map<String, Object> message = new HashMap<>();
//        message.put("role", "user");
//        message.put("content", newQuestion);
//        list.add(message);
//
//        //组装参数
//        HashMap<String, Object> params = new HashMap<>();
//        params.put("messages", list);
//        params.put("model", "gpt-3.5-turbo-0301"); //只能用gpt-3.5-turbo, gpt-3.5-turbo-0301
//        //请求chatGPT接口
//        String result = HttpRequest.post(NEW_URL)
//                .auth("Bearer " + API_KEY)
//                .contentType("application/json")
//                .body(JSONUtil.toJsonStr(params))
//                .execute()
//                .body();
//        ChatGptResult chatGptResult = JSONUtil.toBean(result, ChatGptResult.class);
//        return chatGptResult.getChoices().get(0).getMessage().getContent();
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int number = 10; //提问次数
//        List<ChatGptParam> historyAnswer = new ArrayList<>();
//        System.out.println("ChatGPT问答开始");
//        while (number > 0) {
//            number --;
//            System.out.print("问：");
//            String question = scanner.nextLine();
//            String answer = ChatGptUtil.chatGPTRequest(historyAnswer, question).replaceAll("\n", "");
//            System.out.println("答：" + answer);
//            historyAnswer.add(ChatGptParam.builder().question(question).answer(answer).build());
//        }
//        System.out.println("ChatGPT问答结束");
//    }
//}
