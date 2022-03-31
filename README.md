# 書籍管理

* docker啟動方式：
    - sudo docker run -t -d -p 8085:8085 books
    
* 新增/修改書籍
    - API路徑 POST [http://localhost:8085/books/save](http://localhost:8085/books/save) 
    - json欄位無id為新增，有id為修改，範例如下：
    - 新增
      - request 
      <code>{"bookName":"string","author":"string","translator":"string","isbn":"string","publisher":"string","publicationDate":"2022-03-30T12:47:40.294Z","price":0}</code>
      - response 
      <code>{"id":12,"bookName":"快樂實現自主富有","author":"Eric Jorgenson","translator":"謝佩妏","isbn":"9789863987420","publisher":"天下雜誌","publicationDate":"2022-03-30","price":356,"createdDate":"2022-03-30 13:08:41","modifiedDate":"2022-03-30 21:08:41"}</code>
    - 修改 
      - request
      <code>{"id":1,"bookName":"string","author":"string","translator":"string","isbn":"string","publisher":"string","publicationDate":"2022-03-30T12:47:40.294Z","price":0}</code>
      - response
      <code>{"id":12,"bookName":"快樂實現自主富有","author":"Eric Jorgenson","translator":"謝佩妏","isbn":"9789863987420","publisher":"天下雜誌","publicationDate":"2022-03-30","price":510,"createdDate":"2022-03-30 13:08:41","modifiedDate":"2022-03-30 21:22:36"}</code>

* 查詢書籍
    - API路徑 POST [http://localhost:8085/books/list](http://localhost:8085/books/list)
    - id、bookName、author、translator、isbn、publisher、publicationDate(與publicationEDate搭配使用)、price 皆可當查詢條件,並反回陣列資料
      - request
      <code>
      {"id": 3}
      </code>
      - response
      <code>
      [{"id":3,"bookName":"魔戒首部曲：魔戒現身","author":"J.R.R.托爾金","translator":"朱學恆","isbn":"9789570841008","publisher":"聯經出版公司","publicationDate":"2012-12-10","price":210,"createdDate":"2022-03-30 17:59:22","modifiedDate":null}]
      </code>

* 刪除書籍
    - API路徑 DELETE [http://localhost:8085/books/del/{id}](http://localhost:8085/books/del/{id})
    - 帶入id即刪除該筆資料
    
> swagger API測試路徑：[http://127.0.0.1:8085/swagger-ui/index.html#/](http://127.0.0.1:8085/swagger-ui/index.html#/)