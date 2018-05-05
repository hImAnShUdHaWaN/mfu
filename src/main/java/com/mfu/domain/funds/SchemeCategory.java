package com.mfu.domain.funds;

/**
 * Created by himanshu dhawan on 01-05-2018.
 */
public enum SchemeCategory {

    GROWTH("Growth"),
    INCOME("Income"),
    LIQUID("Liquid"),
    GILT("Gilt"),
    ELSS("ELSS"),
    BALANCED("Balanced"),
    MONEY_MARKET("Money Market"),
    EQUITY_SCHEME_ELSS("Equity Scheme - ELSS"),
    HYBRID_SCHEME_AGGRESSIVE_HYBRID_FUND("Hybrid Scheme - Aggressive Hybrid Fund"),
    EQUITY_SCHEME_LARGE_AND_MID_CAP_FUND("Equity Scheme - Large & Mid Cap Fund"),
    EQUITY_SCHEME_MULTI_CAP_FUND("Equity Scheme - Multi Cap Fund"),
    EQUITY_SCHEME_MID_CAP_FUND("Equity Scheme - Mid Cap Fund"),
    DEBT_SCHEME_DYNAMIC_BOND("Debt Scheme - Dynamic Bond"),
    EQUITY_SCHEME_SECTORAL_THEMATIC("Equity Scheme - Sectoral/ Thematic"),
    DEBT_SCHEME_MEDIUM_TO_LONG_DURATION_FUND("Debt Scheme - Medium to Long Duration Fund"),
    EQUITY_SCHEME_LARGE_CAP_FUND("Equity Scheme - Large Cap Fund"),
    DEBT_SCHEME_GILT_FUND("Debt Scheme - Gilt Fund"),
    DEBT_SCHEME_SHORT_DURATION_FUND("Debt Scheme - Short Duration Fund"),
    FLOATING_RATE("Floating Rate"),
    OTHER_SCHEME_INDEX_FUNDS("Other Scheme - Index Funds"),
    SOLUTION_ORIENTED_SCHEME_CHILDREN_S_FUND("Solution Oriented Scheme - Children s Fund"),
    DEBT_SCHEME_MEDIUM_DURATION_FUND("Debt Scheme - Medium Duration Fund"),
    HYBRID_SCHEME_EQUITY_SAVINGS("Hybrid Scheme - Equity Savings"),
    OTHER_ETFS("Other ETFs"),
    FUND_OF_FUNDS_DOMESTIC("Fund of Funds - Domestic"),
    ASSURED_RETURN("Assured Return"),
    OTHER_SCHEME_FOF_DOMESTIC("Other Scheme - FoF Domestic"),
    FUND_OF_FUNDS_OVERSEAS("Fund of Funds - Overseas"),
    EQUITY_SCHEME_VALUE_FUND("Equity Scheme - Value Fund"),
    EQUITY_SCHEME_DIVIDEND_YIELD_FUND("Equity Scheme - Dividend Yield Fund"),
    HYBRID_SCHEME_DYNAMIC_ASSET_ALLOCATION_OR_BALANCED_ADVANTAGE("Hybrid Scheme - Dynamic Asset Allocation or Balanced Advantage"),
    DEBT_SCHEME_LOW_DURATION_FUND("Debt Scheme - Low Duration Fund"),
    DEBT_SCHEME_LIQUID_FUND("Debt Scheme - Liquid Fund"),
    EQUITY_SCHEME_FOCUSSED_FUND("Equity Scheme - Focussed Fund"),
    EQUITY_SCHEME_CONTRA_FUND("Equity Scheme - Contra Fund"),
    GOLD_ETFS("GOLD ETFs"),
    HYBRID_SCHEME_ARBITRAGE_FUND("Hybrid Scheme - Arbitrage Fund"),
    DEBT_SCHEME_CORPORATE_BOND_FUND("Debt Scheme - Corporate Bond Fund"),
    OTHER_SCHEME_GOLD_ETF("Other Scheme - Gold ETF"),
    OTHER_SCHEME_OTHER_ETFS("Other Scheme - Other  ETFs"),
    DEBT_SCHEME_LONG_DURATION_FUND("Debt Scheme - Long Duration Fund"),
    HYBRID_SCHEME_MULTI_ASSET_ALLOCATION("Hybrid Scheme - Multi Asset Allocation"),
    DEBT_SCHEME_MONEY_MARKET_FUND("Debt Scheme - Money Market Fund"),
    DEBT_SCHEME_BANKING_AND_PSU_FUND("Debt Scheme - Banking and PSU Fund"),
    DEBT_SCHEME_ULTRA_SHORT_DURATION_FUND("Debt Scheme - Ultra Short Duration Fund"),
    HYBRID_SCHEME_CONSERVATIVE_HYBRID_FUND("Hybrid Scheme - Conservative Hybrid Fund"),
    EQUITY_SCHEME_SMALL_CAP_FUND("Equity Scheme - Small Cap Fund"),
    SOLUTION_ORIENTED_SCHEME_RETIREMENT_FUND("Solution Oriented Scheme - Retirement Fund"),
    OTHER_SCHEME_FOF_OVERSEAS("Other Scheme - FoF Overseas"),
    DEBT_SCHEME_CREDIT_RISK_FUND("Debt Scheme - Credit Risk Fund");

    private String name;

    SchemeCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static SchemeCategory contains(String test) {
        for (SchemeCategory c : SchemeCategory.values()) {
            if (c.getName().equals(test)) {
                return c;
            }
        }
        return null;
    }
}
