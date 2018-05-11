package com.test.controller;

import com.test.model.request.AliModel;
import com.test.model.response.LineChartResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

@RestController
public class AngularController {
	@RequestMapping(value = "/sacma/bisey", method = RequestMethod.GET)
	public AliModel getSometring() {
		AliModel aliModel = new AliModel();
		aliModel.setAppVersion("12");
		aliModel.setDeviceOsVersion("123.123");
		aliModel.setParola("parola");
		aliModel.setSifreNetIndex("index");
		return aliModel;
	}

	@RequestMapping(value = "/sacma/bisey", method = RequestMethod.POST)
	public AliModel getSometring(@Valid @RequestBody AliModel model) {
		System.out.println(model);
		return model;
	}

	@RequestMapping(value = "sacma/bisey/cok", method = RequestMethod.POST)
	public List<AliModel> getAliModels(@Valid @RequestBody AliModel model) {
		System.out.println(model);

		List<AliModel> aliModels = new LinkedList<>();
		for (Integer i = 1; i < 11; i++) {
			AliModel aliModel = new AliModel();
			aliModel.setSifreNetIndex(i.toString() + " " + model.getSifreNetIndex());
			aliModel.setParola(i.toString() + " " + model.getParola());
			aliModel.setDeviceOsVersion(i.toString() + " " + model.getDeviceOsVersion());
			aliModel.setAppVersion(i.toString() + " " + model.getAppVersion());
			aliModels.add(aliModel);
		}
		return aliModels;
	}

	@RequestMapping(value = "/chart/line-chart", method = RequestMethod.POST)
	public LineChartResponse getLineChart() {


		return initData();
	}

	private LineChartResponse initData() {
		LineChartResponse response = new LineChartResponse();
		List<Integer> list1 = new LinkedList<>();
		list1.add(1);
		list1.add(10);
		list1.add(5);
		list1.add(8);
		list1.add(15);
		list1.add(20);
		list1.add(10);
		list1.add(1);
		list1.add(8);
		list1.add(7);
		list1.add(22);
		response.setList1(list1);
		List<Integer> list2 = new LinkedList<>();
		list2.add(20);
		list2.add(10);
		list2.add(21);
		list2.add(1);
		list2.add(2);
		list2.add(5);
		list2.add(6);
		list2.add(1);
		list2.add(20);
		list2.add(10);
		list2.add(15);
		response.setList2(list2);
		List<Integer> list3 = new LinkedList<>();
		list3.add(5);
		list3.add(20);
		list3.add(10);
		list3.add(15);
		list3.add(25);
		list3.add(8);
		list3.add(11);
		list3.add(22);
		list3.add(6);
		list3.add(25);
		list3.add(10);
		response.setList3(list3);
		List<String> labels = new LinkedList<>();
		labels.add("A");
		labels.add("B");
		labels.add("C");
		labels.add("Ç");
		labels.add("D");
		labels.add("E");
		labels.add("F");
		labels.add("G");
		labels.add("Ğ");
		labels.add("H");
		labels.add("I");
		response.setLabels(labels);
		List<String> series = new LinkedList<>();
		series.add("Ali");
		series.add("Osman");
		series.add("Mahmut");
		response.setSeries(series);
		return response;
	}
}
