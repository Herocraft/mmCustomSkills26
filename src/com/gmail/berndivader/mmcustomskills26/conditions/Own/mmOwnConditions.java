package com.gmail.berndivader.mmcustomskills26.conditions.Own;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.gmail.berndivader.mmcustomskills26.Main;

import io.lumine.xikage.mythicmobs.api.bukkit.events.MythicConditionLoadEvent;
import io.lumine.xikage.mythicmobs.skills.SkillCondition;

public class mmOwnConditions implements Listener {

	public mmOwnConditions() {
		Bukkit.getServer().getPluginManager().registerEvents(this, Main.getPlugin());
		Bukkit.getLogger().info("Register CustomConditions");
	}

	@EventHandler
	public void onMythicMobsConditionsLoadEvent(MythicConditionLoadEvent e) {
		String conditionName = e.getConditionName().toLowerCase();
		switch (conditionName) {
		case "vdistance": {
			SkillCondition c = new mmVerticalDistanceCondition(e.getConfig().getLine(), e.getConfig());
			e.register(c);
			break;
		}
		case "hastarget": {
			SkillCondition c = new mmHasTargetCondition(e.getConfig().getLine(), e.getConfig());
			e.register(c);
			break;
		}
		case "mobsinradius": {
			SkillCondition c = new mmMobsInRadiusCondition(e.getConfig().getLine(), e.getConfig());
			e.register(c);
			break;
		}
		case "lastdamagecause": {
			SkillCondition c = new mmLastDamageCauseCondition(e.getConfig().getLine(), e.getConfig());
			e.register(c);
			break;
		}
		case "stunned":
		case "isstunned": {
			SkillCondition c = new mmIsStunnedCondition(e.getConfig().getLine(), e.getConfig());
			e.register(c);
			break;
		}
		case "biomefix": {
			SkillCondition c = new mmBiomeFixCondition(e.getConfig().getLine(), e.getConfig());
			e.register(c);
			break;
		}
		case "hasmeta":
		case "hasmetasimple": {
			SkillCondition c = new mmHasMetaTagCondition(e.getConfig().getLine(), e.getConfig());
			e.register(c);
			break;
		}
		case "behind": {
			SkillCondition c = new mmIsBehindCondition(e.getConfig().getLine(), e.getConfig());
			e.register(c);
			break;
		}
		case "infront": {
			SkillCondition c = new mmInFrontCondition(e.getConfig().getLine(), e.getConfig());
			e.register(c);
			break;
		}
		case "damageable":
		case "attackable": {
			SkillCondition c = new mmIsAttackableCondition(e.getConfig().getLine(),e.getConfig());
			e.register(c);
			break;
		}
		case "parsedstance":
		case "pstance": {
			SkillCondition c = new mmParsedStanceCondition(e.getConfig().getLine(),e.getConfig());
			e.register(c);
			break;
		}
		case "health": {
			SkillCondition c = new Healthcondition(e.getConfig().getLine(),e.getConfig());
			e.register(c);
			break;
		}
		case "facingdirection": {
			SkillCondition c = new FacingDirectionCondition(e.getConfig().getLine(),e.getConfig());
			e.register(c);
			break;
		}
		case "inmotion": {
			SkillCondition c = new InMotionCondition(e.getConfig().getLine(),e.getConfig());
			e.register(c);
			break;
		}
		case "iteminhand":
			case "ownsitem": {
			SkillCondition c = new hasItemCondition(e.getConfig().getLine(), e.getConfig());
			e.register(c);
			break;
		}case "relativedirection": {
			SkillCondition c = new DirectionalDamageCondition(e.getConfig().getLine(),e.getConfig());
			e.register(c);
			break;
		}case "lookatme":
			case "looksatme": {
			SkillCondition c = new LookingAtMeCondition(e.getConfig().getLine(),e.getConfig());
			e.register(c);
			break;
		}case "samefaction": {
				SkillCondition c = new SameFactionCondition(e.getConfig().getLine(),e.getConfig());
				e.register(c);
				break;
		}
		case "infaction": {
			SkillCondition c = new InFactionCondition(e.getConfig().getLine(),e.getConfig());
			e.register(c);
			break;
		}case "owneralive": {
			SkillCondition c=new OwnerAliveCondition(e.getConfig().getLine(),e.getConfig());
			e.register(c);
			break;
		}case "playerweather":{
			SkillCondition c=new PlayerWeatherCondition(e.getConfig().getLine(),e.getConfig());
			e.register(c);
			break;
		}case "playertime":{
			SkillCondition c=new PlayerTimeCondition(e.getConfig().getLine(),e.getConfig());
			e.register(c);
			break;
		}case "entitiesinradius":
			case "eir":
			case "leir":
			case "livingentitiesinradius":
			case "pir":
			case "playersinradius":{
			SkillCondition c=new EntitiesInRadiusCondition(e.getConfig().getLine(), e.getConfig());
			e.register(c);
			break;
		}case "isburning": {
			SkillCondition c=new IsBurningCondition(e.getConfig().getLine(),e.getConfig());
			e.register(c);
			break;
		}case "ispresent": {
			SkillCondition c=new IsTargetPresentCondition(e.getConfig().getLine(),e.getConfig());
			e.register(c);
			break;
		}case "isvehicle": {
			SkillCondition c=new IsVehicleCondition(e.getConfig().getLine(),e.getConfig());
			e.register(c);
			break;
		}case "isgoggling":{
			SkillCondition c=new IsGogglingCondition(e.getConfig().getLine(),e.getConfig());
			e.register(c);
			break;
		}case "isspinning":{
			SkillCondition c=new IsSpinningCondition(e.getConfig().getLine(),e.getConfig());
			e.register(c);
			break;
		}case "hasspawner":{
			SkillCondition c=new HasMythicSpawnerCondition(e.getConfig().getLine(),e.getConfig());
			e.register(c);
			break;
		}case "samespawner":{
			SkillCondition c=new SameMythicSpawnerCondition(e.getConfig().getLine(),e.getConfig());
			e.register(c);
			break;
		}case "crouching": 
			case "running":
			case "disguised":
			case "sleeping":
			case "jumping":{
				SkillCondition c=new PlayerBooleanConditions(e.getConfig().getLine(),e.getConfig());
				e.register(c);
				break;
		}case "arrowcount":{
			SkillCondition c=new ArrowOnEntityCondition(e.getConfig().getLine(),e.getConfig());
			e.register(c);
			break;
		}}
	}
}
