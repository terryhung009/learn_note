var request = require('request');
var cheerio = require('cheerio')

request('http://ithelp.ithome.com.tw/articles?tab=tech', function (error, response, body) {
  if (!error && response.statusCode == 200) {
    var $ = cheerio.load(body);
    $('.qa-list__title-link').each(function(index, element) {
      console.log($(element).text());
    })
  }
})