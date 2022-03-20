package org.xpathbaseclass;


public class BaseClassNewFrame{
	public static WebDriver driver;
		
	// 1.get driver

	public static void getDriver() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	// 2.find element by id

	public static WebElement findElementById(String AttributeValue) {

		WebElement element = driver.findElement(By.id(AttributeValue));
		return element;

	}

	// 3. find element by name

	public static WebElement findElementByname(String AttributeValue) {

		WebElement element = driver.findElement(By.name(AttributeValue));
		return element;
	}

	// 4. find element by className

	public static WebElement findElementByclassName(String AttributeValue) {
		WebElement element = driver.findElement(By.className(AttributeValue));
		return element;
	}

	// 5. find element by xpath

	public static WebElement findElementByXpath(String xpath) {

		WebElement element = driver.findElement(By.xpath(xpath));
		return element;

	}
	
	public static WebElement findElementsbytagname(String tagname ) {
	WebElement element = (WebElement) driver.findElements(By.tagName(tagname));
	return element;
	}
	
	// 6. getText

	public static String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	// 7. getAttribute value

	public static String getAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}

	// 8. get attribute second one

	public static String getAttribute(WebElement element, String AttributeName) {
		String attribute = element.getAttribute(AttributeName);
		return attribute;
	}

	// 9. get Title

	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	// 10. get Current URL

	public static String getCurrentUrl() {

		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	// 11. get URL

	public static void getUrl(String url) {

		driver.get(url);

	}

	// 12. Sendkeys

	public static void sendkey(WebElement element, String text) {

		element.sendKeys(text);

	}

	// 13. click

	public static void click(WebElement element) {
		element.click();
	}

	// 14. maximize

	public static void maxi() {

		driver.manage().window().maximize();

	}

	// 15. JavaScript sendkeys

	public static void javaScriptSendKeys(WebElement element, String text) {

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("argument[0].SetAttribute('value','" + text + "')", element);

	}

	// 16. Javascript click

	public static void javaScriptClick(WebElement element) {

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("argument[0].click()", element);

	}

	// 17. Javascript scrollup

	public static void scrollUp(WebElement element) {

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].ScrollUIntoView(false)", element);

	}

	// 18. Javascript scrolldown

	public static void scrollDown(WebElement element) {

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].ScrollUIntoView(true)", element);

	}

	// 19. Navigate to()

	public static void to(String Url) {

		driver.navigate().to(Url);

	}

	// 20. Navigate Back()

	public static void back() {
		driver.navigate().back();

	}

	// 21. Navigate forward()

	public static void forward() {
		driver.navigate().forward();

	}

	// 22. Navigate refrsh()

	public static void refresh() {
		driver.navigate().refresh();

	}

	// 23. Alerts accept

	public static Alert accept() {

		Alert al = driver.switchTo().alert();
		al.accept();
		return al;

	}

	// 24. Alerts dismiss

	public static Alert dismiss() {

		Alert al = driver.switchTo().alert();
		al.dismiss();
		return al;

	}

	// 25. Alerts sendkeys

	public static Alert sendkeys(String Url) {

		Alert al = driver.switchTo().alert();
		al.sendKeys(Url);
		return al;

	}

	// 26. Screenshot getScreenshot As

	public static void getScreenshotAS(WebElement element) {

		TakesScreenshot screenShot = (TakesScreenshot) driver;

		File src = element.getScreenshotAs(OutputType.FILE);

	}

	// 27. get data

	// excelSheet

	public static String getData(String SheetName, int rownum, int cellnum) throws IOException {
		String res = null;
		File file = new File("C:\\Users\\SUNDHARAPANDIAN M\\PomFrameWork\\excel\\spframeworkTest.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(rownum);
		org.apache.poi.ss.usermodel.Cell cell = row.getCell(cellnum);
		CellType type = cell.getCellType();
		switch (type) {
		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yy");
				res = dateformat.format(dateformat);
			} else {
				double d = cell.getNumericCellValue();
				BigDecimal num = BigDecimal.valueOf(d);
				res = num.toString();
			}
		default:
			break;
		}
		return res;
	}

	// 28. SelectOptionByText

	public static void selectOptionByText(WebElement element, String text) {

		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	public static void selectByIndex(WebElement element, int index) {
		Select select1 = new Select(element);
		select1.selectByIndex(index);
	}

	// 29. create new cell and row (WRITE DATA)

	public static void WriteData(String sheetname, int rownum, int cellnum, String value) throws IOException {
		String res = null;
		File file = new File("C:\\Users\\SUNDHARAPANDIAN M\\PomFrameWork\\excel\\spframeworkTest.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		org.apache.poi.ss.usermodel.Cell cell = row.createCell(cellnum);
		cell.setCellValue(value);
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}

	// 30. implicit wait
	public static void implicitWait(int sec) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	// 31. properties

	public static String prop(String text) throws IOException {

		Properties prop = new Properties();

		FileReader reader = new FileReader(new File("C:\\Users\\SUNDHARAPANDIAN M\\FrameWork\\configProperties"));

		prop.load(reader);

		String string = prop.get(text).toString();

		return string;

	}

	// Alert

	public static void alertaccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

}
