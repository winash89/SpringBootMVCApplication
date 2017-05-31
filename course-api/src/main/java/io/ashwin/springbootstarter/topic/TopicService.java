package io.ashwin.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	private List<topics> topics = new ArrayList<>(Arrays.asList(
			new topics("spring","spring framework","spring framework descriptoion"),
			new topics("java","java framework","java framework descriptoion"),
			new topics("javascript","javascript framework","javascript framework descriptoion")
			));
	
	public List<topics> getAllTopics(){
		return topics;
	}
	
	public topics getTopic(String id){
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(topics topic) {
		topics.add(topic);
	}

	public void updateTopic(topics topic, String id) {
		
		for(int i=0; i<topics.size(); i++){ 
			topics t = topics.get(i);
			if(t.getId().equals(id)){
				topics.set(i, topic);
				return;
			}	
		}
		
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}

}
