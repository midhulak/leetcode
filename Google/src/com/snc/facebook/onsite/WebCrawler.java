package com.snc.facebook.onsite;

public class WebCrawler {
	
	 public List<String> crawl(String startUrl, HtmlParser htmlParser) {
	        
	      // List<String> urls = htmlParser.getUrls(startUrl);
	        
	        String hostName = startUrl.split("/")[2];
	        Crawler crawler = new Crawler(startUrl , hostName , htmlParser);
	        crawler.results = new HashSet<String>();
	        Thread thread = new Thread(crawler);
	        thread.start();
	        crawler.join(thread);
	        return new ArrayList<String>(crawler.results);
	        
	    }
	}
	    
	    class Crawler implements Runnable{
	        String startUrl;
	        String hostName;
	        HtmlParser htmlParser;
	        static  Set<String> results = new HashSet<String>();
	        
	        public Crawler(String startUrl , String hostName , HtmlParser htmlParser){
	            this.startUrl = startUrl;
	            this.hostName = hostName;
	            this.htmlParser = htmlParser;
	            
	        }
	        
	        @Override
	        public void run(){
	            if(!startUrl.contains(hostName) || results.contains(startUrl))
	                return;
	            addUrl(results,startUrl);
	            List<Thread> threads = new ArrayList<Thread>();
	            
	            for(String url : htmlParser.getUrls(startUrl)){
	                
	                Crawler crawler = new Crawler(url , hostName , htmlParser);
	                Thread thread = new Thread(crawler);
	                thread.start();
	                threads.add(thread);
	            }
	            
	            for(Thread t : threads)
	                join(t);
	            
	        }
	        
	        
	        public void join(Thread t){
	            try{
	                t.join();
	            }
	            catch(Exception e){
	                
	            }
	        }
	        
	        public static synchronized void addUrl(Set<String> results , String url){
	            results.add(url);
	        }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
