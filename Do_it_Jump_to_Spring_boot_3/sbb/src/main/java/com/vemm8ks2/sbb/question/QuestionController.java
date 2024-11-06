package com.vemm8ks2.sbb.question;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class QuestionController {
  
  private final QuestionService questionService;

  @GetMapping("/question/list")
  public String list(Model model) {
    List<Question> questionList = questionService.getList();
    model.addAttribute("questionList", questionList);
    return "question_list";
  }
  
  @GetMapping(value = "/question/detail/{id}")
  public String detail(Model model, @PathVariable("id") Integer id) {
    Question question = questionService.getQuestion(id);
    model.addAttribute("question", question);
    return "question_detail";
  }
}
