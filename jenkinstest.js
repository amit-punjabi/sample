var webdriver = require('selenium-webdriver'), By = webdriver.By, until = webdriver.until;
var assert = require('assert')
var capabilities = { 'browserName': 'chrome' }

var driver = new webdriver.Builder().usingServer('http://localhost:4444/wd/hub').withCapabilities(capabilities).build();

//Opens http://demo.guru99.com/popup.php
driver.get("http://b04ad5cd.ngrok.io");

driver.findElement(By.xpath('/html/body/p')).getText().then(function(element){
    if(assert.equal("Hello World",element,"FAIL")==undefined){
        console.log("Success");
    }
})


driver.quit();