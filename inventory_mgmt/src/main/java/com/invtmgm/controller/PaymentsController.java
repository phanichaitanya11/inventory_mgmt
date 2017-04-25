package com.invtmgm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.invtmgm.beans.AgentBean;
import com.invtmgm.beans.PaymentBean;
import com.invtmgm.service.AgentsService;
import com.invtmgm.service.PaymentsService;

@Controller
public class PaymentsController {

	@Autowired
	private PaymentsService paymentsService;
	
	@Autowired
	private AgentsService agentsService;
	
	@RequestMapping(value = "/newPayment", method = RequestMethod.GET)
	public String displayNewPayment(Model model) {
		PaymentBean paymentBean = new PaymentBean();
		model.addAttribute("newPaymentForm", paymentBean);
		return "newPayment";
	}
	
	@RequestMapping(value = "/searchAgentForPayment", method = RequestMethod.POST)
	public String searchAgent(@ModelAttribute("agentInfo") AgentBean agent, Model model) {
		if (agent != null) {
			int agentId = agent.getAgentId();
			if (agentId != 0) {
				AgentBean agentInfo = agentsService.getAgent(agentId);
				if (agentInfo == null) {
					model.addAttribute("result", "error");
					model.addAttribute("msg", "Agent not found!");
				} else {
					model.addAttribute("agentExist", true);
					model.addAttribute("agentInfo", agentInfo);
				}
			} else {
				model.addAttribute("result", "error");
				model.addAttribute("msg", "Please enter a valid agent id!");
			}
			PaymentBean payBean = new PaymentBean();
			payBean.setAgentId(agentId);
			model.addAttribute("newPaymentForm", payBean);
		}
		return "newPayment";
	}
	
	@RequestMapping(value = "/newPayment", method = RequestMethod.POST)
	public String makeNewPayment(@ModelAttribute("newPaymentForm") PaymentBean payBean, Model model) {
		if (payBean != null) {
			int paymentId = paymentsService.makePayment(payBean);
			if (paymentId == 0) {
				model.addAttribute("result", "error");
				model.addAttribute("msg", "An error occurred while paying. Please try again later.");
			} else {
				model.addAttribute("paymentId", paymentId);
				model.addAttribute("result", "success");
				model.addAttribute("msg", "Payment successful!");
			}
		} else {
			model.addAttribute("result", "error");
			model.addAttribute("msg", "An error occurred while paying. Please try again later.");
		}
		model.addAttribute("newPaymentForm", payBean);
		return "newPayment";
	}
	
	@RequestMapping(value = "/listPayments", method = RequestMethod.GET)
	public String listPayments(Model model) {
		model.addAttribute("paymentsList", paymentsService.getPaymentsList());
		return "listPayments";
	}
}
