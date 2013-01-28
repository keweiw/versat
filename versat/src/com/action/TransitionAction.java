package com.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.bu.TransitionDay;
import com.dao.FundDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Fund;
import com.pojo.FundPriceHistory;

public class TransitionAction extends ActionSupport {

	private ArrayList<Fund> funds;
	private FundPriceHistory fundPriceHistory;
	private Date lastTradingDate;
	private String lastTradingDateString;
	private Date closingDate;
	private String closingDateString;
	private Double closingPrice;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat df2 = new SimpleDateFormat("MM-dd-yyyy");
	private int isSuccess;

	public String showTransition() {
		this.setIsSuccess(0);

		this.lastTradingDate = TransitionDay.getInstance().getLastTransitionDay();
		if (lastTradingDate != null) {
			this.lastTradingDateString = df2.format(this.lastTradingDate);
		} else {
			this.lastTradingDateString = "-";
		}
		
		funds = TransitionDay.getInstance().getFundList();

		return SUCCESS;

	}

	public String transition() {
		Map session = ActionContext.getContext().getSession();

		this.isSuccess = 0;

		this.lastTradingDate = TransitionDay.getInstance()
				.getLastTransitionDay();

		if (lastTradingDate != null) {
			this.lastTradingDateString = df2.format(this.lastTradingDate);
		} else {
			this.lastTradingDateString = "-";
		}

		funds = TransitionDay.getInstance().getFundList();

		if (closingDateString != null) {
			System.out.println(closingDateString);
			try {
				this.closingDate = df.parse(closingDateString);
				System.out.println(closingDate);
				// this.lastTradingDate = df.parse(lastTradingDateString);
				// System.out.println(lastTradingDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (this.lastTradingDate.getTime() >= this.closingDate.getTime()) {
				this.addActionError("Current closing date is illegal, please choose another date!");
				this.setIsSuccess(-1);
				return ERROR;

			} else {
				for (int i = 0; i < funds.size(); i++) {
					funds.get(i).setCur(closingPrice);
					if (funds.get(i).getCur() == 0) {
						this.addActionError("Fund value can not be empty or zero!");
						this.setIsSuccess(-1);
						return ERROR;
					} else {
						isSuccess = TransitionDay.getInstance()
								.commitTransitionDay(funds, closingDate);
						if (isSuccess == 0) {
							return SUCCESS;
						} else if (isSuccess == -1) {
							this.addActionError("This transition is failed!");
							return ERROR;
						} else if (isSuccess == -2) {
							this.addActionError("System busy, please retry later!");
							return ERROR;
						} else if (isSuccess == -3)
							this.addActionError("There is a new fund, please provide its price.");
						return ERROR;
					}
				}

			}

		} else {
			this.addActionError("Closing date can not be empty!");
			this.setIsSuccess(-1);
			return ERROR;
		}

		this.addActionError("Error!");
		this.setIsSuccess(-1);
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

	public Double getClosingPrice() {
		return closingPrice;
	}

	public void setClosingPrice(Double closingPrice) {
		this.closingPrice = closingPrice;
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

}
