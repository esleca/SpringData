<div class="addNewPlayerModal">
	
	<div class="modal-header">
		<h3>Create Player</h3>
	</div>
	
	<div class="modal-body">
	
		<form id="createPlayerForm" name="createPlayerForm" class="form-horizontal" role="form">
			
	
			<div class='form-group'>
				<div ng-class="{error: onError && createPlayerForm.firstName.$invalid}">
					<label class='col-sm-3 control-label'>First Name</label>
					<div class="col-sm-8">
						<input type="text" id="firstname" class="form-control" name="firstname" placeholder="Required" required ng-model="requestObject.player.firstname" />
						<span ng-show="onError && createPlayerForm.firstname.$error.required" class="help-inline">Required</span>						
					</div>
				</div>
			</div>
	
			<div class='form-group'>
				<div ng-class="{error: onError && createPlayerForm.lastName.$invalid}">
					<label class='col-sm-3 control-label'>Last Name</label> 
					<div class="col-sm-8">
						<input type="text" id="lastname" class="form-control" name="lastname" placeholder="Required" required ng-model="requestObject.player.lastname" />
						<span ng-show="onError && createPlayerForm.lastname.$error.required" class="help-inline">Required</span>
					</div>
				</div>
			</div>
	
			<div class='form-group'>
				<div ng-class="{error: onError && createPlayerForm.dorsal.$invalid}">
					<label class='col-sm-3 control-label'>Dorsal</label> 
					<div class="col-sm-8">
						<input type="text" id="dorsal" class="form-control" name="dorsal" placeholder="Required" required ng-model="requestObject.player.dorsal" />
						<span ng-show="onError && createPlayerForm.dorsal.$error.required" class="help-inline">Required</span>
					</div>
				</div>
			</div>
	
		</form>
	</div>
	
	<div class="modal-footer">
		<button class="btn btn-primary" ng-click="createPlayer($event)">Create</button>
		<button class="btn btn-warning" ng-click="cancel()">Cancel</button>
	</div>
	
</div>