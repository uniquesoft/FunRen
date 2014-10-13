package com.fr.station.common.bean.system;

/**
 * Column Type: day_report, month_report.
 * 
 */
public enum ReportTypeEnum {

	DAY_REPORT("1"),
	MONTH_REPORT("2"),
	DEFAULT("DEFAULT");

	private String columnName;

	private ReportTypeEnum(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnName() {
		return this.columnName;
	}
	
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public static ReportTypeEnum getMenuTypeValue(String typeName) {

		ReportTypeEnum tableTypeEnum = null;
		
		ReportTypeEnum[] values = ReportTypeEnum.values();
		for (ReportTypeEnum tableValue : values) {
			if (tableValue.getColumnName().equals(typeName)) {
				tableTypeEnum = tableValue;
			}
		}
		return tableTypeEnum;
	}
	
}

