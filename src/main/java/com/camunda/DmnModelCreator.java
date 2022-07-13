package com.camunda;

import java.io.File;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.camunda.bpm.model.dmn.Dmn;
import org.camunda.bpm.model.dmn.DmnModelInstance;
import org.camunda.bpm.model.dmn.HitPolicy;
import org.camunda.bpm.model.dmn.instance.Decision;
import org.camunda.bpm.model.dmn.instance.DecisionTable;
import org.camunda.bpm.model.dmn.instance.Definitions;
import org.camunda.bpm.model.dmn.instance.Input;
import org.camunda.bpm.model.dmn.instance.InputEntry;
import org.camunda.bpm.model.dmn.instance.InputExpression;
import org.camunda.bpm.model.dmn.instance.Output;
import org.camunda.bpm.model.dmn.instance.OutputEntry;
import org.camunda.bpm.model.dmn.instance.Rule;
import org.camunda.bpm.model.dmn.instance.Text;

import camundajar.impl.scala.Console;

public class DmnModelCreator {

  //check docs for library 
  //https://docs.camunda.org/manual/7.12/user-guide/model-api/dmn-model-api/create-a-model/
  public static void main(String[] args) {

    //define dmn model
    DmnModelInstance modelInstance = Dmn.createEmptyModel();
    Definitions definitions = modelInstance.newInstance(Definitions.class);
    definitions.setNamespace("http://camunda.org/schema/1.0/dmn");
    definitions.setName("definitions");
    definitions.setId("definitions");
    modelInstance.setDefinitions(definitions);
    
    //set id and name for the model
    Decision decision = modelInstance.newInstance(Decision.class);
    decision.setId("testGenerated6");
    decision.setName("generationtest6");
    definitions.addChildElement(decision);
    
    //set hit policy
    DecisionTable decisionTable = modelInstance.newInstance(DecisionTable.class);
    decisionTable.setId("decisionTable");
    decisionTable.setHitPolicy(HitPolicy.UNIQUE);
    decision.addChildElement(decisionTable);
    
    //define first input data type and name
    Input Input1 = modelInstance.newInstance(Input.class);
    Input1.setId("Input_1");
    Input1.setLabel("Season");
    
    InputExpression inputExpression = modelInstance.newInstance(InputExpression.class);
    inputExpression.setId("InputExpression_1");
    inputExpression.setTypeRef("string");
    Text textExpr = modelInstance.newInstance(Text.class);
    textExpr.setTextContent("season");
    inputExpression.setText(textExpr);
    Input1.addChildElement(inputExpression);
    decisionTable.addChildElement(Input1);

    //define 2nd input data type and name
    Input Input2 = modelInstance.newInstance(Input.class);
    Input2.setId("Input_2");
    Input2.setLabel("Number of guests");
    
    InputExpression inputExpression2 = modelInstance.newInstance(InputExpression.class);
    inputExpression2.setId("InputExpression_2");
    inputExpression2.setTypeRef("integer");
    Text textExpr1 = modelInstance.newInstance(Text.class);
    textExpr1.setTextContent("guestCount");
    inputExpression2.setText(textExpr1);
    Input2.addChildElement(inputExpression2);
    decisionTable.addChildElement(Input2);
    
    //set output data type and name
    Output output = modelInstance.newInstance(Output.class);
    output.setId("Output_1");
    output.setLabel("Dish");
    output.setName("dish");
    output.setTypeRef("string");
    decisionTable.addChildElement(output);
    
    //set first rule first input
    Rule rule = modelInstance.newInstance(Rule.class);
    rule.setId("Rule_1");
    Text text1 = modelInstance.newInstance(Text.class);
    text1.setTextContent("\"Summer\"");
    InputEntry inputEntry = modelInstance.newInstance(InputEntry.class);
    inputEntry.setId("input_1");
    inputEntry.addChildElement(text1);
    
    rule.addChildElement(inputEntry);
    
    //set first rule 2nd input
    Text text2 = modelInstance.newInstance(Text.class);
    text2.setTextContent("<4");
    InputEntry inputEntry1 = modelInstance.newInstance(InputEntry.class);
    inputEntry1.setId("input_2");
    inputEntry1.addChildElement(text2);
    
    rule.addChildElement(inputEntry1);
    
    //set first rule first output
    OutputEntry outputEntry = modelInstance.newInstance(OutputEntry.class);
    outputEntry.setId("output_2");
    
    Text text3 = modelInstance.newInstance(Text.class);
    text3.setTextContent("\"Strawberries\"");
    outputEntry.addChildElement(text3);
    
    rule.addChildElement(outputEntry);
    decisionTable.addChildElement(rule);
  
    //set 2nd rule 1st input
    Rule rule2 = modelInstance.newInstance(Rule.class);
    Text text4 = modelInstance.newInstance(Text.class);
    text4.setTextContent("\"Summer\"");
    InputEntry inputEntry2 = modelInstance.newInstance(InputEntry.class);
    inputEntry2.setId("input_3");
    inputEntry2.addChildElement(text4);
    
    rule2.addChildElement(inputEntry2);
    
     //set 2nd rule 2nd input
    Text text5 = modelInstance.newInstance(Text.class);
    text5.setTextContent(">=4");
    InputEntry inputEntry3 = modelInstance.newInstance(InputEntry.class);
    inputEntry3.setId("input_4");
    inputEntry3.addChildElement(text5);
    
    rule2.addChildElement(inputEntry3);
    
     //set 2nd rule output
    OutputEntry outputEntry1 = modelInstance.newInstance(OutputEntry.class);
    outputEntry1.setId("output_1");
    
    Text text6 = modelInstance.newInstance(Text.class);
    text6.setTextContent("\"Icecream\"");
    outputEntry1.addChildElement(text6);
    
    rule2.addChildElement(outputEntry1);
    decisionTable.addChildElement(rule2);
    
    //set 3rd rule
    Rule rule3 = modelInstance.newInstance(Rule.class);
    Text text7 = modelInstance.newInstance(Text.class);
    text7.setTextContent("\"Spring\"");
    InputEntry inputEntry4 = modelInstance.newInstance(InputEntry.class);
    inputEntry4.setId("input_5");
    inputEntry4.addChildElement(text7);
    
    rule3.addChildElement(inputEntry4);
    
    Text text8 = modelInstance.newInstance(Text.class);
    text8.setTextContent(">=4");
    InputEntry inputEntry5 = modelInstance.newInstance(InputEntry.class);
    inputEntry5.setId("input_6");
    inputEntry5.addChildElement(text8);
    
    rule3.addChildElement(inputEntry5);
    
    OutputEntry outputEntry2 = modelInstance.newInstance(OutputEntry.class);
    outputEntry2.setId("output_3");
    
    Text text9 = modelInstance.newInstance(Text.class);
    text9.setTextContent("\"Chocolate\"");
    outputEntry2.addChildElement(text9);
    
    rule3.addChildElement(outputEntry2);
    decisionTable.addChildElement(rule3);

    Dmn.validateModel(modelInstance);
    
    System.out.println(Dmn.convertToString(modelInstance));
    // validate and write model to file
    Dmn.validateModel(modelInstance);

    //ready for POST REST API
    HttpPost post = new HttpPost("https://camunda-bpm-platform-camunda.mycluster-sng01-b3c-4x16-bcdccc6907863a505408259211d02150-0000.jp-tok.containers.appdomain.cloud/engine-rest/deployment/create");
    MultipartEntityBuilder builder = MultipartEntityBuilder.create();
    builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
    
    //send file as bytes
    //ByteArrayOutputStream filestream = new ByteArrayOutputStream();
    //Dmn.writeModelToStream(filestream, modelInstance);
    //byte[] dmnBytes = filestream.toByteArray();
    //builder.addBinaryBody("data", dmnBytes);
   
    //build request body, attach file
    File myObj = new File("test.dmn");
    Dmn.writeModelToFile(myObj, modelInstance);
    builder.addBinaryBody("data", myObj);
    builder.addTextBody("deployment-name","test6" );
    HttpEntity entity = (HttpEntity) builder.build();
    post.setEntity(entity);
    CloseableHttpClient client = HttpClientBuilder.create()
          .build();
          try
          {
            CloseableHttpResponse  response = client.execute(post);
            System.out.println(response);
            myObj.delete();
          }
          catch(Exception IOException)
          {
            Console.println(IOException.toString());
          }     
  }

}
