package org.elsys.ip.rest.resource;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;
import org.elsys.ip.rest.model.Star;
import org.elsys.ip.rest.service.StarService;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

@Path("/stars")
public class StarResource {
    private StarService starService = new StarService();


    @GET
    @Produces("application/json")
    public List<Star> getStarList(@Context UriInfo uriInfo) {

        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();


        if(queryParams.containsKey("id") && queryParams.get("id").size() > 1){
            return  starService.filterByIds(queryParams);
        }

        return starService.filterByQueryParams(queryParams);
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Star getStar(@PathParam("id") Integer id) {
        return starService.getStarById(id);
    }


    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadStar(File file) {

             try {
                 CSVParser parser = CSVParser.parse(file, StandardCharsets.US_ASCII, CSVFormat.EXCEL);
                 List<CSVRecord> records = parser.getRecords();

            for (int counter = 4; counter < records.size() - 1; counter++) {
                System.out.println(records.get(counter));
                System.out.println(records.get(counter).get(1));

              CSVRecord record = records.get(counter);

               starService.saveStar(new Star(
                       Integer.parseInt(record.get(0)),
                       record.get(1),
                       Long.parseLong(record.get(2)),
                       record.get(3),
                       Long.parseLong(record.get(4)),
                       Integer.parseInt(record.get(5)),
                       Long.parseLong(record.get(6)),
                       Long.parseLong(record.get(7)),
                       record.get(8),
                       Long.parseLong(record.get(9)),
                       Long.parseLong(record.get(10)))
               );
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return Response.status(200).build();

    }

    @GET
    @Path("/download")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response downloadStar() {


        File file = new File("C:\\Users\\DaniT\\Desktop\\stars.csv");

        try {

            PrintStream fileStream = new PrintStream(file);
            int counter = 0;
            for(; counter < starService.getStarList().size() - 1; counter++){
                fileStream.println(starService.getStarList().get(counter).toString());

            }
            fileStream.print(starService.getStarList().get(counter).toString());

        }catch (Exception ex){
            ex.printStackTrace();
        }

        return Response
                .ok(file)
                .header("Content-Disposition", "attachment; filename=" + file.getName())
                .build();


    }


    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Star saveStar(Star star) {
        return starService.saveStar(star);
    }


    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/multiple")
    public List<Star> saveStars(List<Star> stars) {

        return starService.saveStars(stars);
    }


    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Star updateStar(@PathParam("id") Integer id, Star star) {
        return starService.updateStar(id, star);
    }


    @DELETE
    @Path("/{id}")
    public void deleteStar(@PathParam("id") Integer id) {
        starService.deleteStar(id);
    }

}
