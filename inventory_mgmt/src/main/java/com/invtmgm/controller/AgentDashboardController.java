package com.invtmgm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.invtmgm.beans.AgentBean;
import com.invtmgm.beans.DailyTranBean;
import com.invtmgm.beans.PaymentBean;
import com.invtmgm.service.AgentBalanceService;
import com.invtmgm.service.AgentsService;
import com.invtmgm.service.DailyTranService;
import com.invtmgm.service.PaymentsService;

@Controller
public class AgentDashboardController {

	@Autowired
	private AgentsService agentsService;
	
	@Autowired
	private AgentBalanceService agentBalanceService;
	
	@Autowired
	private PaymentsService paymentsService;
	
	@Autowired
	private DailyTranService dailyTranService;
	
	@RequestMapping(value = "/agentDashboard", method = RequestMethod.GET)
	public String displayAddAgent(Model model) {
		AgentBean agentBean = new AgentBean();
		model.addAttribute("viewAgentForm", agentBean);
		return "agentDashboard";
	}
	
	@RequestMapping(value = "/agentDashboard", method = RequestMethod.POST)
	public String searchAgent(@ModelAttribute("viewAgentForm") AgentBean agent, Model model) {
		if (agent != null) {
			int agentId = agent.getAgentId();
			if (agentId != 0) {
				AgentBean agentInfo = agentsService.getAgent(agentId);
				if (agentInfo == null) {
					model.addAttribute("result", "error");
					model.addAttribute("msg", "Agent not found!");
				} else {
					agentInfo.setOutstandingBal(agentBalanceService.getAgentBalance(agentId));
					model.addAttribute("agentExist", true);
					model.addAttribute("agentInfo", agentInfo);
					List<PaymentBean> paymentsList = paymentsService.getPaymentsListForAgent(agentId);
					model.addAttribute("payments", paymentsList);
					List<DailyTranBean> transactionsList = dailyTranService.getTransactionsListForAgent(agentId);
					model.addAttribute("transactions", transactionsList);
					model.addAttribute("noOfApprovedPdts", dailyTranService.getNoOfApprovedPdtsForCurrentMonth(agentId));
				}
			} else {
				model.addAttribute("result", "error");
				model.addAttribute("msg", "Please enter a valid agent id!");
			}
		}
		return "agentDashboard";
	}
}
