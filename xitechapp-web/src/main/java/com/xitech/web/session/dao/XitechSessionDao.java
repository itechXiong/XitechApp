package com.xitech.web.session.dao;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;


public class XitechSessionDao extends CachingSessionDAO{
	
	
	// inject the actual template
    @Autowired
    private RedisTemplate<String, String> redisCache;
    
    @Resource(name="redisTemplate")
    private ValueOperations<String, Object> valueRedis;

	@Override
	protected void doUpdate(Session session) {
		// TODO Auto-generated method stub
		if(session instanceof ValidatingSession && !((ValidatingSession)session).isValid()) {
			return ;
		}
		System.out.println("*******************update session**********************");
		String sessionId = session.getId().toString();
		byte[] sessionByte = (byte[])valueRedis.get(sessionId);
		if(sessionByte!=null && sessionByte.length>0) {
			//SimpleSession sessionold = (SimpleSession)byteToSession(sessionByte);
			valueRedis.set(sessionId, sessionToByte(session),session.getTimeout(),TimeUnit.SECONDS);
		}else {
			session.stop();
			return ;
		}
		
		
		 
	}

	@Override
	protected void doDelete(Session session) {
		// TODO Auto-generated method stub
		 System.out.println("*******************delete session**********************");
		valueRedis.getOperations().delete(session.getId().toString());
	}

	@Override
	protected Serializable doCreate(Session session) {
		// TODO Auto-generated method stub
		 Serializable sessionId =generateSessionId(session);
		 System.out.println("*******************create session**********************");
		 assignSessionId(session, sessionId);
		 String sessionIdStr = session.getId().toString();
		 valueRedis.set(sessionId.toString(), sessionToByte(session),session.getTimeout(),TimeUnit.SECONDS);
		 return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		// TODO Auto-generated method stub
		SimpleSession session = null;
		System.out.println("*******************read session**********************");
		/*session = (SimpleSession)valueRedis.get(sessionId);
		*/
		byte[] sessionByte = (byte[])valueRedis.get(sessionId);
		if(sessionByte!=null && sessionByte.length>0) {
			session = (SimpleSession)byteToSession(sessionByte);
		}
		
		return session;
	}
	
	
	/**
     * 把session对象转化为byte数组
     * @param session
     * @return
     */
    public byte[] sessionToByte(Session session){
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        byte[] bytes = null;
        try {
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(session);
            bytes = bo.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }
 
    /**
     * 把byte数组还原为session
     * @param bytes
     * @return
     */
    public Session byteToSession(byte[] bytes){
        ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
        ObjectInputStream in;
        Session session = null;
        try {
            in = new ObjectInputStream(bi);
            session = (SimpleSession) in.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return session;
    }

}
