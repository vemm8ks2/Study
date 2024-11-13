package com.vemm8ks2.sbb.answer;

import java.security.Principal;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.vemm8ks2.sbb.question.Question;
import com.vemm8ks2.sbb.question.QuestionService;
import com.vemm8ks2.sbb.user.SiteUser;
import com.vemm8ks2.sbb.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

  private final QuestionService questionService;
  private final AnswerService answerService;
  private final UserService userService;

  @PreAuthorize("isAuthenticated()")
  @PostMapping("/create/{id}")
  public String createAnswer(Model model, @PathVariable("id") Integer id,
      @Valid AnswerForm answerForm, BindingResult bindingResult, Principal principal) {
    Question question = questionService.getQuestion(id);
    SiteUser siteUser = userService.getUser(principal.getName());

    if (bindingResult.hasErrors()) {
      model.addAttribute("question", question);
      return "question_detail";
    }

    answerService.create(question, answerForm.getContent(), siteUser);

    return String.format("redirect:/question/detail/%s", id);
  }
}
