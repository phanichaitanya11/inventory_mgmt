package com.invtmgm.controller;

import com.invtmgm.beans.AgentBean;
import com.invtmgm.service.AgentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AgentsController
{
  @org.springframework.beans.factory.annotation.Autowired
  private AgentsService agentsService;
  
  public AgentsController() {}
  
  @RequestMapping(value={"/addAgent"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String displayAddAgent(Model model)
  {
    AgentBean agentBean = new AgentBean();
    model.addAttribute("addAgentForm", agentBean);
    return "addAgent";
  }
  
  @RequestMapping(value={"/addAgent"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String addAgent(@ModelAttribute("addAgentForm") AgentBean agent, Model model) {
    if (agent != null) {
      int agentId = agentsService.addAgent(agent);
      if (agentId != 0) {
        model.addAttribute("result", "success");
        model.addAttribute("msg", "Successfully added a new agent!<br/>Agent Id : " + agentId);
      } else {
        model.addAttribute("result", "error");
        model.addAttribute("msg", "An error has occurred while adding agent.");
      }
      model.addAttribute("addAgentForm", agentsService.getAgent(agentId));
    }
    return "addAgent";
  }
  
  @RequestMapping(value={"/viewAgent"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String viewAgent(Model model) {
    AgentBean agentBean = new AgentBean();
    model.addAttribute("viewAgentForm", agentBean);
    return "viewAgent";
  }
  
  @RequestMapping(value={"/viewAgent"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String viewAgent(@ModelAttribute("viewAgentForm") AgentBean agent, Model model) {
    if (agent != null) {
      int agentId = agent.getAgentId();
      if (agentId != 0) {
        AgentBean agentInfo = agentsService.getAgent(agentId);
        if (agentInfo == null) {
          model.addAttribute("result", "error");
          model.addAttribute("msg", "Agent not found!");
        } else {
          model.addAttribute("agentExist", Boolean.valueOf(true));
          model.addAttribute("viewAgentForm", agentInfo);
        }
      } else {
        model.addAttribute("result", "error");
        model.addAttribute("msg", "Please enter a valid agent id!");
      }
    }
    return "viewAgent";
  }
  
  @RequestMapping(value={"/updateAgent"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String updateAgent(@ModelAttribute("viewAgentForm") AgentBean agent, Model model) {
    if (agent != null) {
      AgentBean agentInfo = agentsService.updateAgent(agent);
      if (agentInfo == null) {
        model.addAttribute("result", "error");
        model.addAttribute("msg", "An error occurred while updating the agent information!");
      } else {
        model.addAttribute("result", "success");
        model.addAttribute("agentExist", Boolean.valueOf(true));
        model.addAttribute("viewAgentForm", agentInfo);
        model.addAttribute("msg", "Agent information updated successfully!");
      }
    }
    return "viewAgent";
  }
  
  @RequestMapping(value={"/searchAgent"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String deleteAgent(Model model) {
    AgentBean agentBean = new AgentBean();
    model.addAttribute("viewAgentForm", agentBean);
    return "deleteAgent";
  }
  
  @RequestMapping(value={"/searchAgent"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String searchAgent(@ModelAttribute("viewAgentForm") AgentBean agent, Model model) {
    if (agent != null) {
      int agentId = agent.getAgentId();
      if (agentId != 0) {
        AgentBean agentInfo = agentsService.getAgent(agentId);
        if (agentInfo == null) {
          model.addAttribute("result", "error");
          model.addAttribute("msg", "Agent not found!");
        } else {
          model.addAttribute("agentExist", Boolean.valueOf(true));
          model.addAttribute("viewAgentForm", agentInfo);
        }
      } else {
        model.addAttribute("result", "error");
        model.addAttribute("msg", "Please enter a valid agent id!");
      }
    }
    return "deleteAgent";
  }
  
  @RequestMapping(value={"/deleteAgent"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String deleteAgent(@ModelAttribute("viewAgentForm") AgentBean agent, Model model) {
    if (agent != null) {
      boolean deleteSuccess = agentsService.deleteAgent(agent.getAgentId());
      if (!deleteSuccess) {
        model.addAttribute("result", "error");
        model.addAttribute("msg", "An error occurred while deleting agent information!");
      } else {
        model.addAttribute("result", "success");
        model.addAttribute("msg", "Agent information deleted successfully!");
      }
    }
    return "deleteAgent";
  }
  
  @RequestMapping(value={"/listAgents"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String listAgents(Model model) {
    model.addAttribute("agentsList", agentsService.getAgentsList());
    return "listAgents";
  }
}