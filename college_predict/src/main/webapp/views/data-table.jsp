
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>College Cut Offs</title>
    <link
      rel="stylesheet"
      type="text/css"
      href="https://cdn.datatables.net/v/dt/dt-1.11.3/datatables.min.css"
    />
    <script
      type="text/javascript"
      src="https://code.jquery.com/jquery-3.6.0.min.js"
    ></script>
    <script
      type="text/javascript"
      src="https://cdn.datatables.net/v/dt/dt-1.11.3/datatables.min.js"
    ></script>
    
  </head>
  <body>
    <P style="margin-bottom: 10%;"></P>
          <div class="col-sm-12">
            <!-- <centre>
            <h2 class="font-weight-bold text-center font-size-res-24 " style="margin-top: 5%;">
                <span style="color: rgb(1, 5, 12);"> COLLEGE LIST </span>
            </h2>
            </centre> -->
            <br><br>
            <!-- <img
              src="img/exam-flow.png"
              class="center-auto w-70 mt-5"
              alt="exam Flow"
            /> -->
          </div>
          <div class="containerx">
            <div class="absdiv">
              <div class="div3">
                <div class="row justify-content-center mt-5">
                  <div class="col-md-11">
                    <div class="card">
                      <div class="card-body">
                        <table id="collegeTable">
                          <thead>
                            <tr>
                              <th>College ID</th>
                              <th>College Name</th>
                              <th>College Type</th>
                              <th>City</th>
                              <th>Branch ID</th>
                              <th>Branch Name</th>  
                              <th>Ranking</th>
                              <th>Percentage</th>
                            </tr>
                          </thead>
                          <tbody>
                           
                          </tbody>
                        </table>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <script>
      $(document).ready(function() {
        $('#collegeTable').DataTable({
          "order": [[0, "asc"]],
          "paging": true,
          "searching": true,
          "lengthChange": true,
          "pageLength": 10,
          "language": {
            "emptyTable": "No data available in table"
          },
          "ajax": {
            "url": "/api/colleges",
            "dataSrc": ""
          },
          "columns": [
            { "data": "college_ID" },
            { "data": "college_Name" },
            { "data": "type" },
            { "data": "city" },
            { "data": "branch_Id" },
            { "data": "branchName" },
            { "data": "ranking" },
            { "data": "percentage" }
          ]
        });
      });
  
        // $(document).ready( function () {
        //   $.ajax({
        //     url: "<?php echo base_url('Index/sdata'); ?>",
        //     type: "GET",
        //     dataType: "json",
        //     success: function(data) {
        //       $('#collegeTable').DataTable({
        //         data: data,
        //         columns: [
        //           { data: 'college_ID' },
        //           { data: 'college_Name' },
        //           { data: 'type' },
        //           { data: 'city' },
        //           { data: 'branch_ID' },
        //           { data: 'branch_name' },
        //           { data: 'ranking' },
        //           { data: 'percentage' },
        //         ],
        //         columnDefs: [
        //           { width: '5%', targets: 0 },
        //           { width: '15%', targets: 1 },
        //           { width: '15%', targets: 2 },
        //           { width: '10%', targets: 3 },
        //           { width: '15%', targets: 4 },
        //           { width: '10%', targets: 5 },
        //           { width: '25%', targets: 6 },
        //           { width: '25%', targets: 7 },
        //           { className: 'center', 
        //             targets: [0, 1, 2, 3, 4, 5, 6,7]
        //           },
        //           { orderable: false, targets: [6,7]}
        //         ]
        //       });
        //     }
        //   });
        // });     
    </script> 
  </body>
</html>
