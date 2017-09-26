<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>14F</title>

<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 5px;
	text-align: center;
}

#circle1 {
	width: 10px;
	height: 10px;
	background: #6188CA;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	white-space: nowrap;
}

#circle2 {
	width: 10px;
	height: 10px;
	background: #FFF270;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	white-space: nowrap;
}

#circle3 {
	width: 10px;
	height: 10px;
	background: #FF8A19;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	white-space: nowrap;
}

/*   파란색   */
.available {
	background-color: #6188CA;
}

/*   노란색   */
.occupied {
	background-color: #FFF270;
}

/*   주황색   */
.no-available {
	background-color: #FF8A19;
}
</style>
</head>

<body>
	<h2 align="center">14F</h2>

	<div class="largetable1" align="center"
		style="float: left; width: 18%; padding: 10px;">
		<table id="table1" style="width: 70%">
			<tr>
				<td class="occupied">1</td>
				<td class="no-available">5</td>
			</tr>
			<tr>
				<td class="available">2</td>
				<td class="occupied">6</td>
			</tr>
			<tr>
				<td class="no-available">3</td>
				<td class="occupied">7</td>
			</tr>
			<tr>
				<td class="available">4</td>
				<td class="available">8</td>
			</tr>
		</table>
	</div>
	
	<div class="largetable1" align="center"
		style="float: left; width: 18%; padding: 10px;">
		<table id="table2" style="width: 70%">
			<tr>
				<td class="available">9</td>
				<td class="available">13</td>
			</tr>
			<tr>
				<td class="available">10</td>
				<td class="occupied">14</td>
			</tr>
			<tr>
				<td class="available">11</td>
				<td class="occupied">15</td>
			</tr>
			<tr>
				<td class="occupied">12</td>
				<td class="occupied">16</td>
			</tr>
		</table>
	</div>
	
	<div class="largetable1" align="center"
		style="float: left; width: 18%; padding: 10px;">
		<table id="table3" style="width: 70%">
			<tr>
				<td class="occupied">17</td>
				<td class="occupied">21</td>
			</tr>
			<tr>
				<td class="available">18</td>
				<td class="available">22</td>
			</tr>
			<tr>
				<td class="occupied">19</td>
				<td class="no-available">23</td>
			</tr>
			<tr>
				<td class="available">20</td>
				<td class="available">24</td>
			</tr>
		</table>
	</div>

	<div class="largetable1" align="center"
		style="float: left; width: 18%; padding: 10px;">

		<table id="table3" style="width: 70%">
			<tr>
				<td class="occupied">25</td>
				<td class="available">29</td>
			</tr>
			<tr>
				<td class="occupied">26</td>
				<td class="no-available">30</td>
			</tr>
			<tr>
				<td class="no-available">27</td>
				<td class="available">31</td>
			</tr>
			<tr>
				<td class="available">28</td>
				<td class="available">32</td>
			</tr>
		</table>
	</div>
	<div class="largetable1" align="center"
		style="float: left; width: 18%; padding: 10px;">
		<table id="table4" style="width: 70%">
			<tr>
				<td class="available">33</td>
				<td class="occupied">37</td>
			</tr>
			<tr>
				<td class="available">34</td>
				<td class="occupied">38</td>
			</tr>
			<tr>
				<td class="occupied">35</td>
				<td class="available">39</td>
			</tr>
			<tr>
				<td class="occupied">36</td>
				<td class="available">40</td>
			</tr>
		</table>
	</div>
	<br>

	<div class="largetable1" align="right"
		style="float: left; width: 93%; padding: 10px;">
		<table id="table7" style="width: 20%">
			<tr>
				<td class="available">55</td>
				<td class="occupied">56</td>
				<td class="available">57</td>
				<td class="occupied">58</td>
			</tr>
			<tr>
				<td class="occupied">59</td>
				<td class="available">60</td>
				<td class="available">61</td>
				<td class="available">62</td>
		</table>
		<br>
	</div>
	<br>

	<div class="largetable1" align="right"
		style="float: left; width: 30%; padding: 10px;">

		<table id="table5" style="width: 70%">
			<tr>
				<td class="occupied">41</td>
				<td class="available">42</td>
				<td class="available">43</td>
			</tr>
			<tr>
				<td class="available">44</td>
				<td class="no-available">45</td>
				<td class="occupied">46</td>
		</table>
	</div>
	<div class="largetable1" align="right"
		style="float: left; width: 30%; padding: 10px;">
		<table id="table6" style="width: 70%">
			<tr>
				<td class="no-available">47</td>
				<td class="available">48</td>
				<td class="available">49</td>
				<td class="available">50</td>
			</tr>
			<tr>
				<td class="available">51</td>
				<td class="occupied">52</td>
				<td class="available">53</td>
				<td class="available">54</td>
		</table>
	</div>
	<div class="largetable1" align="right"
		style="float: left; width: 30%; padding: 10px;">
		<table id="table8" style="width: 70%">
			<tr>
				<td class="available">63</td>
				<td class="occupied">64</td>
				<td class="available">65</td>
				<td class="available">66</td>
			</tr>
			<tr>
				<td class="occupied">67</td>
				<td class="available">68</td>
				<td class="available">69</td>
				<td class="available">70</td>
		</table>
	</div>

	<div align="right" class="circle123" 
		style="float: left; width: 90%; padding: 10px;">
		<h5 id=circle1>&nbsp;&nbsp;&nbsp;사용 가능</h5>
		<h5 id=circle2>&nbsp;&nbsp;&nbsp;사용 중</h5>
		<h5 id=circle3>&nbsp;&nbsp;&nbsp;사용 불가</h5>
	</div>


</body>
</html>