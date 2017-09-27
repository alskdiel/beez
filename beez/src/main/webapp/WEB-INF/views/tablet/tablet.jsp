<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<!-- jQuery 2.1.4 -->
<script src="./resources/jQuery/jQuery-2.1.4.min.js"></script>

<body>
	<h2 align="center">14F</h2>

	<div class="largetable1" align="center"
		style="float: left; width: 18%; padding: 10px;">
		<table id="table1" style="width: 70%">
			<tr>
				<td class="occupied" id='14f-a-1'>1</td>
				<td class="no-available" id='14f-a-5'>5</td>
			</tr>
			<tr>
				<td class="available" id='14f-a-2'>2</td>
				<td class="occupied" id='14f-a-6'>6</td>
			</tr>
			<tr>
				<td class="no-available" id='14f-a-3'>3</td>
				<td class="occupied" id='14f-a-7'>7</td>
			</tr>
			<tr>
				<td class="available" id='14f-a-4'>4</td>
				<td class="available" id='14f-a-8'>8</td>
			</tr>
		</table>
	</div>

	<div class="largetable1" align="center"
		style="float: left; width: 18%; padding: 10px;">
		<table id="table2" style="width: 70%">
			<tr>
				<td class="available" id='14f-a-9'>9</td>
				<td class="available" id='14f-a-13'>13</td>
			</tr>
			<tr>
				<td class="available" id='14f-a-10'>10</td>
				<td class="occupied" id='14f-a-14'>14</td>
			</tr>
			<tr>
				<td class="available" id='14f-a-11'>11</td>
				<td class="occupied" id='14f-a-15'>15</td>
			</tr>
			<tr>
				<td class="occupied" id='14f-a-12'>12</td>
				<td class="occupied" id='14f-a-16'>16</td>
			</tr>
		</table>
	</div>

	<div class="largetable1" align="center"
		style="float: left; width: 18%; padding: 10px;">
		<table id="table3" style="width: 70%">
			<tr>
				<td class="occupied" id='14f-a-17'>17</td>
				<td class="occupied" id='14f-a-21'>21</td>
			</tr>
			<tr>
				<td class="available" id='14f-a-18'>18</td>
				<td class="available" id='14f-a-22'>22</td>
			</tr>
			<tr>
				<td class="occupied" id='14f-a-19'>19</td>
				<td class="no-available" id='14f-a-23'>23</td>
			</tr>
			<tr>
				<td class="available" id='14f-a-20'>20</td>
				<td class="available" id='14f-a-24'>24</td>
			</tr>
		</table>
	</div>

	<div class="largetable1" align="center"
		style="float: left; width: 18%; padding: 10px;">

		<table id="table3" style="width: 70%">
			<tr>
				<td class="occupied" id='14f-b-25'>25</td>
				<td class="available" id='14f-b-29'>29</td>
			</tr>
			<tr>
				<td class="occupied" id='14f-b-26'>26</td>
				<td class="no-available" id='14f-b-30'>30</td>
			</tr>
			<tr>
				<td class="no-available" id='14f-b-27'>27</td>
				<td class="available" id='14f-b-31'>31</td>
			</tr>
			<tr>
				<td class="available" id='14f-b-28'>28</td>
				<td class="available" id='14f-b-32'>32</td>
			</tr>
		</table>
	</div>
	<div class="largetable1" align="center"
		style="float: left; width: 18%; padding: 10px;">
		<table id="table4" style="width: 70%">
			<tr>
				<td class="available" id='14f-b-33'>33</td>
				<td class="occupied" id='14f-b-37'>37</td>
			</tr>
			<tr>
				<td class="available" id='14f-b-34'>34</td>
				<td class="occupied" id='14f-b-38'>38</td>
			</tr>
			<tr>
				<td class="occupied" id='14f-b-35'>35</td>
				<td class="available" id='14f-b-39'>39</td>
			</tr>
			<tr>
				<td class="occupied" id='14f-b-36'>36</td>
				<td class="available" id='14f-b-40'>40</td>
			</tr>
		</table>
	</div>
	<br>

	<div class="largetable1" align="right"
		style="float: left; width: 93%; padding: 10px;">
		<table id="table7" style="width: 20%">
			<tr>
				<td class="available" id='14f-b-55'>55</td>
				<td class="occupied" id='14f-b-56'>56</td>
				<td class="available" id='14f-b-57'>57</td>
				<td class="occupied" id='14f-b-58'>58</td>
			</tr>
			<tr>
				<td class="occupied" id='14f-b-59'>59</td>
				<td class="available" id='14f-b-60'>60</td>
				<td class="available" id='14f-b-61'>61</td>
				<td class="available" id='14f-b-62'>62</td>
		</table>
		<br>
	</div>
	<br>

	<div class="largetable1" align="right"
		style="float: left; width: 30%; padding: 10px;">

		<table id="table5" style="width: 70%">
			<tr>
				<td class="occupied" id='14f-a-41'>41</td>
				<td class="available" id='14f-a-42'>42</td>
				<td class="available" id='14f-a-43'>43</td>
			</tr>
			<tr>
				<td class="available" id='14f-a-44'>44</td>
				<td class="no-available" id='14f-a-45'>45</td>
				<td class="occupied" id='14f-a-46'>46</td>
		</table>
	</div>
	<div class="largetable1" align="right"
		style="float: left; width: 30%; padding: 10px;">
		<table id="table6" style="width: 70%">
			<tr>
				<td class="no-available" id='14f-b-47'>47</td>
				<td class="available" id='14f-b-48'>48</td>
				<td class="available" id='14f-b-49'>49</td>
				<td class="available" id='14f-b-50'>50</td>
			</tr>
			<tr>
				<td class="available" id='14f-b-51'>51</td>
				<td class="occupied" id='14f-b-52'>52</td>
				<td class="available" id='14f-b-53'>53</td>
				<td class="available" id='14f-b-54'>54</td>
		</table>
	</div>
	<div class="largetable1" align="right"
		style="float: left; width: 30%; padding: 10px;">
		<table id="table8" style="width: 70%">
			<tr>
				<td class="available" id='14f-b-63'>63</td>
				<td class="occupied" id='14f-b-64'>64</td>
				<td class="available" id='14f-b-65'>65</td>
				<td class="available" id='14f-b-66'>66</td>
			</tr>
			<tr>
				<td class="occupied" id='14f-b-67'>67</td>
				<td class="available" id='14f-b-68'>68</td>
				<td class="available" id='14f-b-69'>69</td>
				<td class="available" id='14f-b-70'>70</td>
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