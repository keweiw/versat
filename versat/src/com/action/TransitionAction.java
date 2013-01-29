package com.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.bu.TransitionDay;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Fund;
import com.pojo.FundPriceHistory;

@SuppressWarnings("serial")
public class TransitionAction extends ActionSupport {

	private ArrayList<Fund> funds;
	private FundPriceHistory fundPriceHistory;
	private Date lastTradingDate;
	private String lastTradingDateString;
	private Date closingDate;
	private String closingDateString;
	private ArrayList<Double> closingPrice;
	private ArrayList<Integer> fundid;

	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat df2 = new SimpleDateFormat("MM-dd-yyyy");
	private int isSuccess;

	public String showTransition() {
		this.isSuccess = 0;
		this.lastTradingDate = TransitionDay.getInstance()
				.getLastTransitionDay();
		if (lastTradingDate != null) {
			this.lastTradingDateString = df2.format(this.lastTradingDate);
		} else {
			this.lastTradingDateString = "-";
		}

		funds = TransitionDay.getInstance().getFundList();

		return SUCCESS;

	}

	public String transition() {
		this.isSuccess = 0;
		this.lastTradingDate = TransitionDay.getInstance()
				.getLastTransitionDay();

		if (lastTradingDate != null) {
			this.lastTradingDateString = df2.format(this.lastTradingDate);
		} else {
			this.lastTradingDateString = "-";
		}

		funds = TransitionDay.getInstance().getFundList();

		if (closingDateString != null && !closingDateString.equals("")) {
			// System.out.println(closingDateString);
			try {
				this.closingDate = df.parse(closingDateString);
				System.out.println(closingDate);
				// this.lastTradingDate = df.parse(lastTradingDateString);
				// System.out.println(lastTradingDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				this.addActionError("Current closing date is illegal, please choose another date!");
				this.setIsSuccess(-1);
				return ERROR;
			}
			if (this.lastTradingDate.getTime() >= this.closingDate.getTime()) {
				this.addActionError("Current closing date is illegal, please choose another date!");
				this.setIsSuccess(-1);
				return ERROR;
			} else {
				HashMap<Integer, Integer> idmaps = new HashMap<Integer, Integer>();
				for (int j = 0; j < fundid.size(); j++) {
					idmaps.put(fundid.get(0), j);
				}

				for (int i = 0; i < funds.size(); i++) {
					Fund fund = funds.get(i);
					if (idmaps.containsKey(fund.getId())) {
						int index = idmaps.get(fund.getId());
						if (index > closingPrice.size() || closingPrice.get(index) == null || closingPrice.get(index).equals(0)) {
							this.addActionError("Fund value can not be empty or zero!");
							this.setIsSuccess(-1);
							return ERROR;
						} else {
							fund.setCur(closingPrice.get(index));
						}
					}
					
				}

				int checkNum = TransitionDay.getInstance().commitTransitionDay(
						funds, closingDate);
				// System.out.println("checkNum=" + checkNum);
				if (checkNum == -3) {
					isSuccess = -1;
					this.addActionError("There is a new fund, please provide its price.");
					return ERROR;

				} else if (checkNum == 0) {
					isSuccess = 1;
					return SUCCESS;
				} else if (checkNum == -1) {
					isSuccess = -1;
					this.addActionError("This transition is failed!");
					return ERROR;
				} else if (checkNum == -2) {
					isSuccess = -1;
					this.addActionError("System busy, please retry later!");
					return ERROR;
				}
			}
		}

		else {
			this.addActionError("Closing date can not be empty!");
			this.setIsSuccess(-1);
			return ERROR;
		}

		this.addActionError("Error!");
		this.setIsSuccess(-1);
		return SUCCESS;

	}

	private String checkStatus(int checkNum) {
		// if (checkNum == -3) {
		// isSuccess = -1;
		// this.addActionError("There is a new fund, please provide its price.");
		// checkNum = TransitionDay.getInstance().commitTransitionDay(funds,
		// closingDate);
		// return ERROR;
		// }
		if (checkNum == 0) {
			isSuccess = 1;
			return SUCCESS;
		} else if (checkNum == -1) {
			isSuccess = -1;
			this.addActionError("This transition is failed!");
			return ERROR;
		} else if (checkNum == -2) {
			isSuccess = -1;
			this.addActionError("System busy, please retry later!");
			return ERROR;
		} // else if (checkNum == -3) {
			// isSuccess = -1;
			// this.addActionError("There is a new fund, please provide its price.");
			// return ERROR;
		// }

		this.addActionError("There is a new fund, please provide its price.");
		// checkNum = TransitionDay.getInstance().commitTransitionDay(funds,
		// closingDate)
		return ERROR;

	}

	private String updatePrice() {

		for (int i = 0; i < funds.size(); i++) {
			for (int j = 0; j < fundid.size(); j++) {

				if (funds.get(i).getId().equals(fundid.get(j))) {
					if (closingPrice.get(j) == null
							|| closingPrice.get(j).equals(0)) {
						this.addActionError("Fund value can not be empty or zero!");
						this.setIsSuccess(-1);
						return ERROR;
					} else {
						funds.get(i).setCur(closingPrice.get(j));
					}

				}
			}
		}
		return SUCCESS;

	}

	public ArrayList<Fund> getFunds() {
		return funds;
	}

	public void setFunds(ArrayList<Fund> funds) {
		this.funds = funds;
	}

	public FundPriceHistory getFundPriceHistory() {
		return fundPriceHistory;
	}

	public void setFundPriceHistory(FundPriceHistory fundPriceHistory) {
		this.fundPriceHistory = fundPriceHistory;
	}

	public Date getLastTradingDate() {
		return lastTradingDate;
	}

	public void setLastTradingDate(Date lastTradingDate) {
		this.lastTradingDate = lastTradingDate;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	public String getLastTradingDateString() {
		return lastTradingDateString;
	}

	public void setLastTradingDateString(String lastTradingDateString) {
		this.lastTradingDateString = lastTradingDateString;
	}

	public int getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(int isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getClosingDateString() {
		return closingDateString;
	}

	public void setClosingDateString(String closingDateString) {
		this.closingDateString = closingDateString;
	}

	public ArrayList<Double> getClosingPrice() {
		return closingPrice;
	}

	public void setClosingPrice(ArrayList<Double> closingPrice) {
		this.closingPrice = closingPrice;
	}

	public ArrayList<Integer> getFundid() {
		return fundid;
	}

	public void setFundid(ArrayList<Integer> fundid) {
		this.fundid = fundid;
	}

}
