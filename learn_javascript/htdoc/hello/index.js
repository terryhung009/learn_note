import request from 'request';
import cheerio from 'cheerio';

request('http://ithelp.ithome.com.tw/articles?tab=tech', (error, response, body) => {
  if (!error && response.statusCode == 200) {
    let $ = cheerio.load(body);
    $('.qa-list__title-link').each((index, element) => {
      console.log($(element).text());
    })
  }
})