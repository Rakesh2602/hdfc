<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <title>EMI Calculator</title>
  </head>
  <style> 
  
  body
  {
background-color : #F0E68C;
}
</style>
 <center>
   <div class="container" style="margin-top: 150px;">
    <div class="row">
     <div class="form-group">
      <form action="controllerservlet" method="POST">
      
       <fieldset>
        <legend>EMI Calculator</legend>
        
        <div class="form-group">
         <label class="col-md-4 control-label" for="amount">Enter amount</label>
         <div class="col-md-5">
          <input id="amount" name="amount" type="text" placeholder="" class="form-control input-md">
          </div>
         </div>
        
         <div class="form-group">
          <label class="col-md-4 control-label" for="rate">Enter the Interest Rate</label>
          <div class="col-md-5">
           <input id="rate" name="rate" type="text" placeholder="" class="form-control input-md">
           </div>
          </div>
          
          <div class="form-group">
           <label class="col-md-4 control-label" for="month">Enter the Tensure period</label>
           <div class="col-md-5">
            <input id="month" name="month" type="text" placeholder="" class="form-control input-md">
            </div>
           </div>
           <div class="form-group">
          <label class="col-md-4 control-label" for="rate">Userid
		</label>
          <div class="col-md-5">
           <input id="user" name="user" type="text" placeholder="" class="form-control input-md">
           </div>
          </div>
          <div class="form-group">
          <label class="col-md-4 control-label" for="rate">Id
		</label>
          <div class="col-md-5">
           <input id="id" name="id" type="text" placeholder="" class="form-control input-md">
           </div>
          </div>
          
           <div class="form-group">
            <label class="col-md-4 control-label" for="emi"></label>
            <div class="col-md-4">
             <button id="emi" name="emi" class="btn btn-primary">Calculate EMI</button>
            </div>
           </div>
          </fieldset>
         </form>
        </div>
       </div>
      </div>
    </body>
   </html>
