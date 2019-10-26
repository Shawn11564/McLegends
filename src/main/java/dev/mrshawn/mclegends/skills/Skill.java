package dev.mrshawn.mclegends.skills;

import dev.mrshawn.mclegends.skills.abilities.Ability;

public interface Skill {

	void setMaxLevel(int maxLevel);
	void addAbility(Ability ability);

}
