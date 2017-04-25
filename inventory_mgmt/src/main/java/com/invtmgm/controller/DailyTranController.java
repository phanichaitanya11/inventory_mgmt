package com.invtmgm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.invtmgm.beans.AgentBean;
import com.invtmgm.beans.DailyTranBean;
import com.invtmgm.service.AgentBalanceService;
import com.invtmgm.service.AgentsService;
import com.invtmgm.service.DailyTranService;
import com.invtmgm.utils.Utils;

@Controller
public class DailyTranController {

	@Autowired
	private DailyTranService dailyTranService;
	
	@Autowired
	private AgentsService agentsService;
	
	@Autowired
	private AgentBalanceService agentBalanceService;
	
	@RequestMapping(value = "/incomingTran", method = RequestMethod.GET)
	public String displayIncomingDailyTran(Model model) {
		DailyTranBean tranBean = new DailyTranBean();
		model.addAttribute("newTranForm", tranBean);
		return "incomingDailyTran";
	}
	
	@RequestMapping(value = "/outgoingTran", method = RequestMethod.GET)
	public String displayOutgoingDailyTran(Model model) {
		DailyTranBean tranBean = new DailyTranBean();
		model.addAttribute("newTranForm", tranBean);
		return "outgoingDailyTran";
	}
	
	@RequestMapping(value = "/searchAgentForTran", method = RequestMethod.POST)
	public String searchAgent(@ModelAttribute("agentInfo") AgentBean agent, @ModelAttribute("newTranForm") DailyTranBean tranBean, Model model) {
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
				}
			} else {
				model.addAttribute("result", "error");
				model.addAttribute("msg", "Please enter a valid agent id!");
			}
			tranBean.setAgentId(agentId);
			model.addAttribute("newTranForm", tranBean);
		}
		if (tranBean != null && "I".equalsIgnoreCase(Utils.trimString(tranBean.getTranType()))) {
			return "incomingDailyTran";
		} else {
			return "outgoingDailyTran";
		}
	}
	
	@RequestMapping(value = "/newIncomingTran", method = RequestMethod.POST)
	public String newIncomingTransaction(@ModelAttribute("newTranForm") DailyTranBean tranBean, Model model) {
		if (tranBean != null) {
			int transactionId = dailyTranService.addNewIncomingTran(tranBean);
			if (transactionId == 0) {
				model.addAttribute("result", "error");
				model.addAttribute("msg", "An error occurred. Please try again later.");
			} else {
				model.addAttribute("transactionId", transactionId);
				model.addAttribute("result", "success");
				model.addAttribute("msg", "Transaction successful!");
			}
		} else {
			model.addAttribute("result", "error");
			model.addAttribute("msg", "An error occurred. Please try again later.");
		}
		model.addAttribute("newTranForm", tranBean);
		return "incomingDailyTran";
	}
	
	@RequestMapping(value = "/newOutgoingTran", method = RequestMethod.POST)
	public String newOutgoingTransaction(@ModelAttribute("newTranForm") DailyTranBean tranBean, Model model) {
		if (tranBean != null) {
			int transactionId = dailyTranService.addNewOutgoingTran(tranBean);
			if (transactionId == 0) {
				model.addAttribute("result", "error");
				model.addAttribute("msg", "An error occurred. Please try again later.");
			} else {
				model.addAttribute("transactionId", transactionId);
				model.addAttribute("result", "success");
				model.addAttribute("msg", "Transaction successful!");
			}
		} else {
			model.addAttribute("result", "error");
			model.addAttribute("msg", "An error occurred. Please try again later.");
		}
		model.addAttribute("newTranForm", tranBean);
		return "outgoingDailyTran";
	}
	
	@RequestMapping(value = "/listTransactions", method = RequestMethod.GET)
	public String listTransactions(Model model) {
		model.addAttribute("transactionsList", dailyTranService.getTransactionsList());
		return "listTransactions";
	}
}
