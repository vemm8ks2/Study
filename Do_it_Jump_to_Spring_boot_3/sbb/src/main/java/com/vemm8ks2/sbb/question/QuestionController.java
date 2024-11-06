package com.vemm8ks2.sbb.question;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class QuestionController {
  
  private final QuestionRepository questionRepository;

  @GetMapping("/question/list")
  public String list(Model model) {
    List<Question> questionList = questionRepository.findAll();
    model.addAttribute("questionList", questionList);
    
    questionList.stream().forEach(v -> System.out.println("|| --- " + v));
    
    return "question_list";
  }
}
