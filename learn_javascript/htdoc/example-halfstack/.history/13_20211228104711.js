let count = 1;
$(document).ready(() => {

  $(document).on('click', '.delete', function() {
    $(this).parent().remove();
  })
  $('#btn').click(() => {
    let title = $('input[name=title]').val();
    if(title == '') {
      alert('標題不能空白');
      return;
    }
    $(`<div class="post">
        <h2>${title}</h2>
        <p>這是我的第${count++}篇文章</p>
        <button class="delete">刪除</button>
      </div>`).appendTo('.posts').hide().fadeIn(2000);
  })
})