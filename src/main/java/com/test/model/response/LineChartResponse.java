package com.test.model.response;

import java.util.List;

public class LineChartResponse {
	private List<Integer> list1;
	private List<Integer> list2;
	private List<Integer> list3;
	private List<String> labels;
	private List<String> series;

	public List<Integer> getList1() {
		return list1;
	}

	public void setList1(List<Integer> list1) {
		this.list1 = list1;
	}

	public List<Integer> getList2() {
		return list2;
	}

	public void setList2(List<Integer> list2) {
		this.list2 = list2;
	}

	public List<Integer> getList3() {
		return list3;
	}

	public void setList3(List<Integer> list3) {
		this.list3 = list3;
	}

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

	public List<String> getSeries() {
		return series;
	}

	public void setSeries(List<String> series) {
		this.series = series;
	}

	@Override
	public String toString() {
		return "LineChartResponse{" +
				"list1=" + list1 +
				", list2=" + list2 +
				", list3=" + list3 +
				", labels=" + labels +
				", series=" + series +
				'}';
	}
}
