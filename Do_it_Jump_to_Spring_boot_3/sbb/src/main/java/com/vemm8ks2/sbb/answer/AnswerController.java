package com.vemm8ks2.sbb.answer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.vemm8ks2.sbb.question.Question;
import com.vemm8ks2.sbb.question.QuestionService;
import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

  private final QuestionService questionService;
  private final AnswerService answerService;

  @PostMapping("/create/{id}")
  public String createAnswer(Model model, @PathVariable("id") Integer id,
      @RequestParam(value = "content") String content) {
    Question question = questionService.getQuestion(id);
    answerService.create(question, content);
    // TODO: 답변 저장
    return String.format("redirect:/question/detail/%s", id);
  }
}
