//getting all profiles from sdlc_test_execution for last week and storing it in profileMap(datastructure)
var profileMap={};
var profileCount=0;

   var gr = new GlideAggregate('sdlc_test_execution');
     gr.addEncodedQuery('object.group=b5353b8b9d7131005cb7121175a3a41b^active=true^profileISNOTEMPTY^sys_created_onONLast 3 months@javascript:gs.beginningOfLast3Months()@javascript:gs.endOfLast3Months()');
     gr.addAggregate('count', 'profile.title');
     gr.groupBy('profile.title');
     gr.query();
gs.info("unique profiles in sdlc_test_execution#"+gr.getRowCount());
while(gr.next()){

profileMap[gr.getDisplayValue('profile.title')+''] = true;
profileCount++;
}
var flapperProfilesNotInExecution={};
gs.info("ProfileMap count#"+profileCount);
//getting all flapper profiles so far from sdlc_test_results_instability_tracker table and removing each flapper profile in profileMap(which we already stored in above query)
var insTrackerGR = new GlideAggregate('sdlc_test_results_instability_tracker');
insTrackerGR.addEncodedQuery('u_test_execution.object.group=b5353b8b9d7131005cb7121175a3a41b^u_test_status=Flapper');
insTrackerGR.addAggregate('count', 'u_profile');
     insTrackerGR.groupBy('u_profile');
insTrackerGR.query();
gs.info("flapper profile count in insTrackerGR#"+insTrackerGR.getRowCount());

while(insTrackerGR.next()){
if(profileMap.hasOwnProperty(insTrackerGR.getDisplayValue('u_profile')+"")){
delete profileMap[insTrackerGR.getDisplayValue('u_profile')+""];
}
else{
var obj={};
obj.name = insTrackerGR.getDisplayValue('u_profile')+"";
obj.sys_id=insTrackerGR.u_profile+""

var gr = new GlideRecord('sdlc_test_execution');
gr.addEncodedQuery("object.group=b5353b8b9d7131005cb7121175a3a41b^active=true^profile="+insTrackerGR.u_profile+"");
gr.orderByDESC('sys_created_on');
gr.query();

if(gr.next()){

obj.createdDate=gr.sys_created_on+"";
}

flapperProfilesNotInExecution[insTrackerGR.getDisplayValue('u_profile')+""] = obj;
//gs.info("test not present in profile="+insTrackerGR.getDisplayValue('u_profile'));
}

}

//Once removed all flapper profiles from existing  profileMap the rest in the profileMap which does not have flapper.
var obj={};
var count=0;
for(key in profileMap){
count++;
}



for(i=0 ; i<flapperProfilesNotInExecution.length; i++){

var gr = new GlideRecord('sdlc_test_execution');
gr.addEncodedQuery("object.group=b5353b8b9d7131005cb7121175a3a41b^active=true^profile="+flapperProfilesNotInExecution[i]);
gr.orderByDESC('sys_created_on');
gr.query();
}


obj.profiles=profileMap;
obj.flappersNotInExecution=flapperProfilesNotInExecution;
gs.info("After removing all flapper profiles from sdlc_test_profile total profiles does not have flapper#"+count);
gs.info("flapper profiles not in execution="+flapperProfilesNotInExecution.length);
gs.info("Printing as JSON object for all profiles whcih does not have flapper so far.......");
gs.info(JSON.stringify(obj));');
     gr.addAggregate('count', 'profile.title');
     gr.groupBy('profile.title');
     gr.query();
gs.info("unique profiles in sdlc_test_execution#"+gr.getRowCount());
while(gr.next()){

profileMap[gr.getDisplayValue('profile.title')+''] = true;
profileCount++;
}
var flapperProfilesNotInExecution={};
gs.info("ProfileMap count#"+profileCount);
//getting all flapper profiles so far from sdlc_test_results_instability_tracker table and removing each flapper profile in profileMap(which we already stored in above query)
var insTrackerGR = new GlideAggregate('sdlc_test_results_instability_tracker');
insTrackerGR.addEncodedQuery('u_test_execution.object.group=b5353b8b9d7131005cb7121175a3a41b^u_test_status=Flapper');
insTrackerGR.addAggregate('count', 'u_profile');
     insTrackerGR.groupBy('u_profile');
insTrackerGR.query();
gs.info("flapper profile count in insTrackerGR#"+insTrackerGR.getRowCount());

while(insTrackerGR.next()){
if(profileMap.hasOwnProperty(insTrackerGR.getDisplayValue('u_profile')+"")){
delete profileMap[insTrackerGR.getDisplayValue('u_profile')+""];
}
else{
var obj={};
obj.name = insTrackerGR.getDisplayValue('u_profile')+"";
obj.sys_id=insTrackerGR.u_profile+""

var gr = new GlideRecord('sdlc_test_execution');
gr.addEncodedQuery("object.group=b5353b8b9d7131005cb7121175a3a41b^active=true^profile="+insTrackerGR.u_profile+"");
gr.orderByDESC('sys_created_on');
gr.query();

if(gr.next()){

obj.createdDate=gr.sys_created_on+"";
}

flapperProfilesNotInExecution[insTrackerGR.getDisplayValue('u_profile')+""] = obj;
//gs.info("test not present in profile="+insTrackerGR.getDisplayValue('u_profile'));
}

}

//Once removed all flapper profiles from existing  profileMap the rest in the profileMap which does not have flapper.
var obj={};
var count=0;
for(key in profileMap){
count++;
}



for(i=0 ; i<flapperProfilesNotInExecution.length; i++){

var gr = new GlideRecord('sdlc_test_execution');
gr.addEncodedQuery("object.group=b5353b8b9d7131005cb7121175a3a41b^active=true^profile="+flapperProfilesNotInExecution[i]);
gr.orderByDESC('sys_created_on');
gr.query();
}


obj.profiles=profileMap;
obj.flappersNotInExecution=flapperProfilesNotInExecution;
gs.info("After removing all flapper profiles from sdlc_test_profile total profiles does not have flapper#"+count);
gs.info("flapper profiles not in execution="+flapperProfilesNotInExecution.length);
gs.info("Printing as JSON object for all profiles whcih does not have flapper so far.......");
gs.info(JSON.stringify(obj));