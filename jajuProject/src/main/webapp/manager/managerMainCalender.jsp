<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="daterangepicker ltr show-ranges opensleft show-calendar"
		style="top: 239px; right: 34.25px; left: auto; display: block;">
		<div class="ranges">
			<ul>
				<li data-range-key="Today">Today</li>
				<li data-range-key="Yesterday">Yesterday</li>
				<li data-range-key="Last 7 Days">Last 7 Days</li>
				<li data-range-key="Last 30 Days">Last 30 Days</li>
				<li data-range-key="This Month">This Month</li>
				<li data-range-key="Last Month">Last Month</li>
				<li data-range-key="Custom" class="active">Custom</li>
			</ul>
		</div>
		<div class="drp-calendar left">
			<div class="calendar-table">
				<table class="table-condensed">
					<thead>
						<tr>
							<th></th>
							<th class="prev available"><span></span></th>
							<th colspan="5" class="month"><select class="monthselect"><option
										value="0">January</option>
									<option value="1">February</option>
									<option value="2">March</option>
									<option value="3">April</option>
									<option value="4">May</option>
									<option value="5">June</option>
									<option value="6">July</option>
									<option value="7">August</option>
									<option value="8">September</option>
									<option value="9">October</option>
									<option value="10" selected="selected">November</option>
									<option value="11">December</option></select><select class="yearselect"><option
										value="2012">2012</option>
									<option value="2013">2013</option>
									<option value="2014">2014</option>
									<option value="2015" selected="selected">2015</option></select></th>
							<th></th>
						</tr>
						<tr>
							<th class="week">W</th>
							<th>Mo</th>
							<th>Tu</th>
							<th>We</th>
							<th>Th</th>
							<th>Fr</th>
							<th>Sa</th>
							<th>Su</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="week">44</td>
							<td class="off available" data-title="r0c0">26</td>
							<td class="off available" data-title="r0c1">27</td>
							<td class="off available" data-title="r0c2">28</td>
							<td class="off available" data-title="r0c3">29</td>
							<td class="off available" data-title="r0c4">30</td>
							<td class="weekend off available" data-title="r0c5">31</td>
							<td class="weekend available" data-title="r0c6">1</td>
						</tr>
						<tr>
							<td class="week">45</td>
							<td class="available" data-title="r1c0">2</td>
							<td class="available" data-title="r1c1">3</td>
							<td class="available" data-title="r1c2">4</td>
							<td class="available" data-title="r1c3">5</td>
							<td class="available" data-title="r1c4">6</td>
							<td class="weekend available" data-title="r1c5">7</td>
							<td class="weekend available" data-title="r1c6">8</td>
						</tr>
						<tr>
							<td class="week">46</td>
							<td class="available" data-title="r2c0">9</td>
							<td class="available" data-title="r2c1">10</td>
							<td class="available" data-title="r2c2">11</td>
							<td class="available" data-title="r2c3">12</td>
							<td class="available" data-title="r2c4">13</td>
							<td class="weekend available" data-title="r2c5">14</td>
							<td class="weekend available" data-title="r2c6">15</td>
						</tr>
						<tr>
							<td class="week">47</td>
							<td class="available" data-title="r3c0">16</td>
							<td class="available" data-title="r3c1">17</td>
							<td class="available" data-title="r3c2">18</td>
							<td class="available" data-title="r3c3">19</td>
							<td class="available" data-title="r3c4">20</td>
							<td class="weekend available" data-title="r3c5">21</td>
							<td class="weekend available" data-title="r3c6">22</td>
						</tr>
						<tr>
							<td class="week">48</td>
							<td class="available" data-title="r4c0">23</td>
							<td class="available" data-title="r4c1">24</td>
							<td class="available" data-title="r4c2">25</td>
							<td class="available" data-title="r4c3">26</td>
							<td class="available" data-title="r4c4">27</td>
							<td class="weekend available" data-title="r4c5">28</td>
							<td class="weekend available" data-title="r4c6">29</td>
						</tr>
						<tr>
							<td class="week">49</td>
							<td class="available" data-title="r5c0">30</td>
							<td class="off available" data-title="r5c1">1</td>
							<td class="off available" data-title="r5c2">2</td>
							<td class="off available" data-title="r5c3">3</td>
							<td class="off available" data-title="r5c4">4</td>
							<td class="weekend off available" data-title="r5c5">5</td>
							<td class="weekend off available" data-title="r5c6">6</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="calendar-time" style="display: none;"></div>
		</div>
		<div class="drp-calendar right">
			<div class="calendar-table">
				<table class="table-condensed">
					<thead>
						<tr>
							<th></th>
							<th></th>
							<th colspan="5" class="month"><select class="monthselect"><option
										value="0">January</option>
									<option value="1">February</option>
									<option value="2">March</option>
									<option value="3">April</option>
									<option value="4">May</option>
									<option value="5">June</option>
									<option value="6">July</option>
									<option value="7">August</option>
									<option value="8">September</option>
									<option value="9">October</option>
									<option value="10">November</option>
									<option value="11" selected="selected">December</option></select><select
								class="yearselect"></select></th>
							<th></th>
						</tr>
						<tr>
							<th class="week">W</th>
							<th>Mo</th>
							<th>Tu</th>
							<th>We</th>
							<th>Th</th>
							<th>Fr</th>
							<th>Sa</th>
							<th>Su</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="week">49</td>
							<td class="off available" data-title="r0c0">30</td>
							<td class="available" data-title="r0c1">1</td>
							<td class="available" data-title="r0c2">2</td>
							<td class="available" data-title="r0c3">3</td>
							<td class="available" data-title="r0c4">4</td>
							<td class="weekend available" data-title="r0c5">5</td>
							<td class="weekend available" data-title="r0c6">6</td>
						</tr>
						<tr>
							<td class="week">50</td>
							<td class="available" data-title="r1c0">7</td>
							<td class="available" data-title="r1c1">8</td>
							<td class="available" data-title="r1c2">9</td>
							<td class="available" data-title="r1c3">10</td>
							<td class="available" data-title="r1c4">11</td>
							<td class="weekend available" data-title="r1c5">12</td>
							<td class="weekend available" data-title="r1c6">13</td>
						</tr>
						<tr>
							<td class="week">51</td>
							<td class="available" data-title="r2c0">14</td>
							<td class="available" data-title="r2c1">15</td>
							<td class="available" data-title="r2c2">16</td>
							<td class="available" data-title="r2c3">17</td>
							<td class="available" data-title="r2c4">18</td>
							<td class="weekend available" data-title="r2c5">19</td>
							<td class="weekend available" data-title="r2c6">20</td>
						</tr>
						<tr>
							<td class="week">52</td>
							<td class="available" data-title="r3c0">21</td>
							<td class="available" data-title="r3c1">22</td>
							<td class="available" data-title="r3c2">23</td>
							<td class="available" data-title="r3c3">24</td>
							<td class="available" data-title="r3c4">25</td>
							<td class="weekend available" data-title="r3c5">26</td>
							<td class="weekend available" data-title="r3c6">27</td>
						</tr>
						<tr>
							<td class="week">1</td>
							<td class="available" data-title="r4c0">28</td>
							<td class="available" data-title="r4c1">29</td>
							<td class="available" data-title="r4c2">30</td>
							<td class="active end-date available" data-title="r4c3">31</td>
							<td class="off off disabled" data-title="r4c4">1</td>
							<td class="weekend off off disabled" data-title="r4c5">2</td>
							<td class="weekend off off disabled" data-title="r4c6">3</td>
						</tr>
						<tr>
							<td class="week">2</td>
							<td class="off off disabled" data-title="r5c0">4</td>
							<td class="off off disabled" data-title="r5c1">5</td>
							<td class="off off disabled" data-title="r5c2">6</td>
							<td class="off off disabled" data-title="r5c3">7</td>
							<td class="off off disabled" data-title="r5c4">8</td>
							<td class="weekend off off disabled" data-title="r5c5">9</td>
							<td class="weekend off off disabled" data-title="r5c6">10</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="calendar-time" style="display: none;"></div>
		</div>
		<div class="drp-buttons">
			<span class="drp-selected">06/03/2021 - 12/31/2015</span>
			<button class="cancelBtn btn btn-default btn-small" type="button">Clear</button>
			<button class="applyBtn btn btn-default btn-small btn-primary"
				disabled="disabled" type="button">Submit</button>
		</div>
	</div>
</body>
</html>